import java.util.ArrayList;
import java.util.List;

public class TransactionMetadata {
    private TransactionRef txn;
    private List<String> participatingKeys = new ArrayList<>();
    private TransactionStatus transactionStatus;
}
