//LoansController.java
package learn.authorization.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.Loans;
import learn.authorization.repository.LoanRepository;

@RestController
public class LoansController {

    private LoanRepository loanRepository;

    public LoansController(LoanRepository loanRepository){
        this.loanRepository=loanRepository;
    }

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        // Retrieve a list of loans for the specified customer ID, ordered by start date in descending order
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        // Check if the list is not empty
        if (loans != null ) {
            // Return the list of loans
            return loans;
        }else {
            // Return null if the list is empty
            return null;
        }
    }

}