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
        // Generating a unique service request number
        contact.setContactId(getServiceReqNumber());
        // Setting the creation date to the current date and time
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        // Saving contact inquiry details to the repository
        return contactRepository.save(contact);
    }

    // Helper method to generate a unique service request number
    public String getServiceReqNumber() {
        Random random = new Random();
        // Generating a random number within a specific range
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        // Combining the random number with a prefix to create the service request number
        return "SR"+ranNum;
    }
}