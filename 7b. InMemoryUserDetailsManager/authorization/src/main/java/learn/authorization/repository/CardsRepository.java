//CardsRepository.java
package learn.authorization.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.authorization.model.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {
	
	List<Cards> findByCustomerId(int customerId);

}