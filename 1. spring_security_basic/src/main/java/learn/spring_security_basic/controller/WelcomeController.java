// WelcomeController.java
package learn.spring_security_basic.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    
    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to Spring Application With Basic Security";
    }
}
