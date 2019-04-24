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
@RequestMapping(path = "{/dsw2}")
public class CardControlador {
    @Autowired
    private CardRepositorio rep;

    @GetMapping(path = {"/Card", "/Card/"})
    public List<Card> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public Card retriveOne(@PathVariable Integer id) {
        Optional<Card> Cardog = rep.findById(id);
        return Cardog.get();

    }

    @PostMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public ResponseEntity<Object> create(@RequestBody Card cardog) {
        Card entity = rep.save(cardog);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Card cardog) {
        Optional<Card> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cardog.setId(id);
        rep.save(cardog);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(path = {"/Card/{id}", "/Card/{id}/"})
    public void delete(@PathVariable Integer id) {
        rep.deleteById(id);
    }
    }




