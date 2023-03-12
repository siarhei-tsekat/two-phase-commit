public class TransactionClient {

    private TransactionRef transactionRef;
    private TransactionalKVStore coordinator;

    public TransactionClient(ReplicaMapper replicaMapper, SystemClock systemClock) {
        this.clock = systemClock;
        this.transactionRef = new TransactionRef(clock.now());
        this.replicaMapper = replicaMapper;
    }

    private void maybeBeginTransaction(String key) {
        if (coordinator == null) {
            coordinator = replicaMapper.serverFor(key);
            coordinator.begin(transactionRef);
        }
    }
}
