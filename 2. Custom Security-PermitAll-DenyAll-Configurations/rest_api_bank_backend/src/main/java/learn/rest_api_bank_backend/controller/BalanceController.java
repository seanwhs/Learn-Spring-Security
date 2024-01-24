package learn.rest_api_bank_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BalanceController {
    @GetMapping("/myBalance")
    public String getBalanceDetails(){
        return "These are the balance details from the DB";
    }
}
