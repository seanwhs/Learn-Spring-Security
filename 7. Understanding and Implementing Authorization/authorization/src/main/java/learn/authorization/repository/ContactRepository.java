//ContactRepository.java
package learn.authorization.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.authorization.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	
}