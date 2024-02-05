package learn.defining_and_managing_users.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ContactController {
    
    @GetMapping("/contact")
    public String saveContactInquiryDetails(){
        return "InquiryDetails are saved to DB";
    }
}
