package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Model.Card;
import com.cibertec.dsw2.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {


    @Autowired
    private CardService cardService;

    @GetMapping(path = "/card")
    public ResponseEntity<Object> retriveAll() {
        return cardService.getAll();
    }

    @GetMapping(path = "/card/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return cardService.getOne(id);
    }

    @PostMapping(path = "/card")
    public ResponseEntity<Object> create(@RequestBody Card card) {
        return cardService.insert(card);
    }

    @PutMapping(path = "/card/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Card card) {
        return cardService.update(id, card);
    }

    @DeleteMapping(path = "/card/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return cardService.delete(id);
    }
}




