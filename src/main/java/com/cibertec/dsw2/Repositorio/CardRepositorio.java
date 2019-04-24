package com.cibertec.dsw2.Repositorio;

import com.cibertec.dsw2.Modelo.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CardRepositorio extends JpaRepository<Card,Integer> {

}
