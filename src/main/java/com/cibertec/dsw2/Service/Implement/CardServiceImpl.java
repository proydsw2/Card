package com.cibertec.dsw2.Service.Implement;

import com.cibertec.dsw2.Model.Card;
import com.cibertec.dsw2.Repository.CardRepository;
import com.cibertec.dsw2.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {

   @PersistenceContext
   private EntityManager em;

   @Autowired
   CardRepository cardRepository;

   public ResponseEntity<Object> getAll() {
      try {
         List<Card> cards = cardRepository.findAll();

         if (cards == null) {
            return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok().body(cards);
      } catch (Exception e) {
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> getOne(Integer id) {
      try {
         Optional<Card> card = cardRepository.findById(id);

         if (!card.isPresent()) {
            return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok().body(card);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> insert(Card card) {
      try {
         Card entity = cardRepository.save(card);

         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
           .buildAndExpand(entity.getNum_card_id()).toUri();

         return ResponseEntity.ok().body(entity);

      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> update(Integer id, Card card) {
      try {
         Optional<Card> entity = cardRepository.findById(id);

         if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
         }

         card.setNum_card_id(id);
         Card cust = cardRepository.save(card);
         return ResponseEntity.ok().body(cust);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }

   public ResponseEntity<Object> delete(Integer id) {

      try {
         Optional<Card> entity = cardRepository.findById(id);
         if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
         }
         cardRepository.deleteById(id);
         return ResponseEntity.ok().build();
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().build();
      }
   }
}
