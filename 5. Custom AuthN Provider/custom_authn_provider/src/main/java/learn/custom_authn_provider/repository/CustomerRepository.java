//CustomerRepository.java
package learn.custom_authn_provider.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.custom_authn_provider.model.Customer;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}
