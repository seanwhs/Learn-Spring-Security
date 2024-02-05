//Customer.java
package learn.authorization.model;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
     @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    // Only accept pwd from UI. Don't send pwd from DB to UI
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    private String createDt;

    @JsonIgnore //Field will NOT be sent to UI app
    @OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
    private Set<Authority> authorities;

    public Customer(String name, String email, String mobileNumber, String pwd, String role, String createDt,
            Set<Authority> authorities) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.pwd = pwd;
        this.role = role;
        this.createDt = createDt;
        this.authorities = authorities;
    }
}
