package learn.defining_and_managing_users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    
    @GetMapping("/myCards")
    public String getCardDetails(){
        return "Card details from DB";
    }
}
