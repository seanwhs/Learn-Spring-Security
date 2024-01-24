package learn.rest_api_bank_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ContactController {
    
    @GetMapping("/contact")
    public String saveContactInquiryDetails(){
        return "InquiryDetails are saved to DB";
    }
}
