//BalanceController.java
package learn.cors_and_csrf.controller;
import org.springframework.web.bind.annotation.RestController;
import learn.cors_and_csrf.model.AccountTransactions;
import learn.cors_and_csrf.repository.AccountTransactionsRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BalanceController {

    private AccountTransactionsRepository accountTransactionsRepository;

    public BalanceController(AccountTransactionsRepository accountTransactionsRepository){
        this.accountTransactionsRepository=accountTransactionsRepository;
    }

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}