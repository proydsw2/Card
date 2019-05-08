package com.cibertec.dsw2.Controlador;


import com.cibertec.dsw2.Modelo.Card;
import com.cibertec.dsw2.Repositorio.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class CardControlador {
    @Autowired
    private CardRepositorio rep;

    @GetMapping(path = {"/Card", "/Card/"})
    public List<Card> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public Card retriveOne(@PathVariable Long id) {
        Optional<Card> card = rep.findById(id);
        return card.get();

    }

    @PostMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public ResponseEntity<Object> create(@RequestBody Card card) {
        Card entity = rep.save(card);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_card_id()).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Card card) {
        Optional<Card> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        card.setNum_card_id(id);
        rep.save(card);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public void delete(@PathVariable Long id) {
        rep.deleteById(id);
    }
    }




