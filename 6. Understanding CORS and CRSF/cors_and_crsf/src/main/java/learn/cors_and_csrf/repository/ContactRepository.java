//ContactRepository.java
package learn.cors_and_csrf.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import learn.cors_and_csrf.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
}