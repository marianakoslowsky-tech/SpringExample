package com.senai.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {


    
} 
    
    

