//ContactController.java
package learn.authorization.controller;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.Contact;
import learn.authorization.repository.ContactRepository;

import java.sql.Date;
import java.util.Random;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ContactController {

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository){
        this.contactRepository=contactRepository;
    }

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }
}