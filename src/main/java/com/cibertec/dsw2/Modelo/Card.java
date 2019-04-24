package com.cibertec.dsw2.Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.persistence.Entity

public class Card {
    @Id
    @GeneratedValue()
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("date")
    private String  date ;

    @JsonProperty("customer_id")
    private int customer_id;

    public Card() {
    }

    public Card(int number, String date, int customer_id) {
        this.number = number;
        this.date = date;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    @Override
    public String toString(){
        return"card: {"+
            "id = "+getId() +
                    "number = " + getNumber()+
                    "date ="+getDate()+
                "customer_id="+getCustomer_id()+"}";


        }
    }
