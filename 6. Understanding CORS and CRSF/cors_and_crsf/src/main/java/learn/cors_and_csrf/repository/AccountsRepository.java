package learn.cors_and_csrf.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import learn.cors_and_csrf.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}