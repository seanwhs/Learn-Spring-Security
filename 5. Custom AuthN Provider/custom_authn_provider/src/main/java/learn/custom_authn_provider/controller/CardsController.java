package learn.custom_authn_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    
    @GetMapping("/myCards")
    public String getCardDetails(){
        return "Card details from DB";
    }
}
