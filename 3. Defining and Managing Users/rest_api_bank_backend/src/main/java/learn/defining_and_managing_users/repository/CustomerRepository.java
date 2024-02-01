//CustomerRepository.java
package learn.defining_and_managing_users.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import learn.defining_and_managing_users.model.Customer;
import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}
