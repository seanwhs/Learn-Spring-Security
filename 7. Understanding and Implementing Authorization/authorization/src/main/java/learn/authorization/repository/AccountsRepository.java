package learn.authorization.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.authorization.model.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}