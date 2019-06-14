package com.cibertec.dsw2.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@SequenceGenerator(name = "seq_card_id", allocationSize = 1)
@Entity
public class Card {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_card_id")
   @Column(name = "num_card_id")
   private Integer num_card_id;

   @Column(name = "num_card_number")
   private String num_card_number;

   @Column(name = "dte_expiration_date")
   private String dte_expiration_date;

   @Column(name = "num_customer_id")
   private int num_customer_id;

}
