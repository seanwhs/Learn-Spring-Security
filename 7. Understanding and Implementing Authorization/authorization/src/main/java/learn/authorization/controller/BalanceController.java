//BalanceController.java
package learn.authorization.controller;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.AccountTransactions;
import learn.authorization.repository.AccountTransactionsRepository;

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
        // Fetching account transactions for the specified customer ID and ordering them by transaction date in descending order
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            // Returning the list of account transactions if not null
            return accountTransactions;
        }else {
            // Returning null if no account transactions are found
            return null;
        }
    }
}