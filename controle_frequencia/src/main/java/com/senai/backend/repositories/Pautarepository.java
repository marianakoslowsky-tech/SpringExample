package com.senai.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.models.Pauta;

@Repository
public interface Pautarepository extends JpaRepository <Pauta, Integer> {

    

    
}
