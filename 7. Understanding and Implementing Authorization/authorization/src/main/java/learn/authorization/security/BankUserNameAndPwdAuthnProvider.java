//BankUserNameAndPwdAuthnProvider.java
package learn.authorization.security;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import learn.authorization.model.Authority;
import learn.authorization.model.Customer;
import learn.authorization.repository.CustomerRepository;

@Service
public class BankUserNameAndPwdAuthnProvider implements AuthenticationProvider {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    // Constructor for dependency injection of CustomerRepository and PasswordEncoder
    public BankUserNameAndPwdAuthnProvider(
        CustomerRepository customerRepository,
        PasswordEncoder passwordEncoder
        ){
            this.customerRepository=customerRepository;
            this.passwordEncoder=passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        // Retrieving the customer details by email
        List<Customer> customer = customerRepository.findByEmail(username);

        // Checking if a customer with the given email exists
        if (customer.size() > 0) {
            // Validating the provided password against the stored hashed password
            if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
                // Creating and returning a new UsernamePasswordAuthenticationToken with granted authorities
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.get(0).getAuthorities()));
            } else {
                // Throwing an exception if the password is invalid
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    // Helper method to convert a set of authorities into a list of GrantedAuthority objects
    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
    
    // Method to check if this authentication provider supports the provided authentication class
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}