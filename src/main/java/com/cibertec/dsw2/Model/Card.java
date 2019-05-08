package com.cibertec.dsw2.Model;

import javax.persistence.*;

@SequenceGenerator(name="seq_card_id", initialValue=1)
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_card_id")
    @Column(name="num_card_id")
    private Long num_card_id;

    @Column(name="num_card_number")
    private int num_card_number;

    @Column(name="dte_expiration_date")
    private String  dte_expiration_date ;

    @Column(name="num_customer_id")
    private int num_customer_id;


    public Card() {
    }


    public Card(int num_card_number, String dte_expiration_date, int num_customer_id) {
        this.num_card_number = num_card_number;
        this.dte_expiration_date = dte_expiration_date;
        this.num_customer_id = num_customer_id;
    }


    @Override
    public String toString() {
        return "Card{" +
                "num_card_id=" + num_card_id +
                ", num_card_number=" + num_card_number +
                ", dte_expiration_date='" + dte_expiration_date + '\'' +
                ", num_customer_id=" + num_customer_id +
                '}';
    }

    public Long getNum_card_id() {
        return num_card_id;
    }

    public void setNum_card_id(Long num_card_id) {
        this.num_card_id = num_card_id;
    }

    public int getNum_card_number() {
        return num_card_number;
    }

    public void setNum_card_number(int num_card_number) {
        this.num_card_number = num_card_number;
    }

    public String getDte_expiration_date() {
        return dte_expiration_date;
    }

    public void setDte_expiration_date(String dte_expiration_date) {
        this.dte_expiration_date = dte_expiration_date;
    }

    public int getNum_customer_id() {
        return num_customer_id;
    }

    public void setNum_customer_id(int num_customer_id) {
        this.num_customer_id = num_customer_id;
    }
}
