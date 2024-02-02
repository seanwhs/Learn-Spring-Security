//Accounts.java
package learn.cors_and_csrf.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;

    @Id
    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private String createDt;

    public Accounts(long accountNumber, String accountType, String branchAddress, String createDt) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.createDt = createDt;
    }

    
}
