//CustomerRepository.java
package learn.password_management.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.password_management.model.Customer;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}
