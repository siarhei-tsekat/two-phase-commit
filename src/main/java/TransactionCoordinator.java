import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionCoordinator {
    Map<TransactionRef, TransactionMetadata> transactions = new ConcurrentHashMap<>();
    WriteAheadLog transactionLog;

    public void begin(TransactionRef transactionRef) {
        TransactionMetadata transactionMetadata = new TransactionMetadata(transactionRef, systemclock, transactionTimeoutMs);
        transactionLog.writeEntry(transactionMetadata.serialize());
        transactions.put(transactionRef, transactionMetadata);
    }
}
