package com.cibertec.dsw2.Service;

import com.cibertec.dsw2.Model.Card;
import org.springframework.http.ResponseEntity;

public interface CardService {

   ResponseEntity<Object> getAll();

   ResponseEntity<Object> getOne(Integer id);

   ResponseEntity<Object> insert(Card card);

   ResponseEntity<Object> update(Integer id, Card card);

   ResponseEntity<Object> delete(Integer id);


}
