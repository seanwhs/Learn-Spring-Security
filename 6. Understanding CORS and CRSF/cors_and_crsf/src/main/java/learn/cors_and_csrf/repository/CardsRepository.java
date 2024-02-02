//CardsRepository.java
package learn.cors_and_csrf.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import learn.cors_and_csrf.model.Cards;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> {
	
	List<Cards> findByCustomerId(int customerId);

}