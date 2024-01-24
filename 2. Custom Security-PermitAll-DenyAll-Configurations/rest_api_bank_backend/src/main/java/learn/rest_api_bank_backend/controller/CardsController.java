package learn.rest_api_bank_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    
    @GetMapping("/myCards")
    public String getCardDetails(){
        return "Card details from DB";
    }
}
