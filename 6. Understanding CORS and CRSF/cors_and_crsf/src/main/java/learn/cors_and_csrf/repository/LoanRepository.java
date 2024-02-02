//LoanRepository.java
package learn.cors_and_csrf.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import learn.cors_and_csrf.model.Loans;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Integer> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}