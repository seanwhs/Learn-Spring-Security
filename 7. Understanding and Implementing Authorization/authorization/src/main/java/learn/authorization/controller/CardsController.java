//CardsController.java
package learn.authorization.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.Cards;
import learn.authorization.repository.CardsRepository;

@RestController
public class CardsController {

    private CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository){
        this.cardsRepository=cardsRepository;
    }

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

}