//CustomerRepository.java
package learn.cors_and_csrf.repository;
import learn.cors_and_csrf.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmail(String email);
    
}