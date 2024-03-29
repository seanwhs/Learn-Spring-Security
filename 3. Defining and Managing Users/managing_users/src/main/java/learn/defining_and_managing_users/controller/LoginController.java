//LoginController.java
package learn.defining_and_managing_users.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import learn.defining_and_managing_users.model.Customer;
import learn.defining_and_managing_users.repository.CustomerRepository;

//REST API to allow users to register
@RestController
public class LoginController {

    private CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity<String> response=null;
        try {
            savedCustomer = customerRepository.save(customer);
            if (savedCustomer!=null && savedCustomer.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

}