//AccountController.java
package learn.authorization.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.Accounts;
import learn.authorization.repository.AccountsRepository;

@RestController
public class AccountController {
    private AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository){
        this.accountsRepository=accountsRepository;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}