//ContactRepository.java
package learn.authorization.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import learn.authorization.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
	
}