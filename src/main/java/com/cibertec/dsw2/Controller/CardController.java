package com.cibertec.dsw2.Controller;


import com.cibertec.dsw2.Model.Card;
import com.cibertec.dsw2.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class CardController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CardRepository repository;

    @GetMapping(path = "/card")
    public List<Card> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/card/{id}")
    public Card retriveOne(@PathVariable Long id) {
        Optional<Card> card = repository.findById(id);
        return card.get();

    }

    @PostMapping(path = "/card")
    public ResponseEntity<Object> create(@RequestBody Card card) {
        Card entity = repository.save(card);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_card_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/card/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Card card) {
        Optional<Card> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        card.setNum_card_id(id);
        repository.save(card);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = "/card/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
    }




