//AccountTransactions.java
package learn.authorization.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_transactions")
public class AccountTransactions {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "transaction_dt")
    private Date transactionDt;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amt")
    private int transactionAmt;

    @Column(name = "closing_balance")
    private int closingBalance;

    @Column(name = "create_dt")
    private String createDt;

    public AccountTransactions(long accountNumber, int customerId, Date transactionDt, String transactionSummary,
            String transactionType, int transactionAmt, int closingBalance, String createDt) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.transactionDt = transactionDt;
        this.transactionSummary = transactionSummary;
        this.transactionType = transactionType;
        this.transactionAmt = transactionAmt;
        this.closingBalance = closingBalance;
        this.createDt = createDt;
    }

}
