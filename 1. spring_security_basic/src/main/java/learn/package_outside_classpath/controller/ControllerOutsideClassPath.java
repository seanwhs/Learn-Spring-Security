package learn.package_outside_classpath.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOutsideClassPath {
    
    @GetMapping("/outside")
    public String greetingFromControllerOutsideClassPath(){
        return "SpringSecurity Secures Everything-- Even Outside Class Path";
    }
}
