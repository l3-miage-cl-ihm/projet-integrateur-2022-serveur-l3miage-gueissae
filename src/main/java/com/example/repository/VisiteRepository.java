package com.example.repository;

import com.example.model.Visite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {

    public Visite findByIdentifiant(Integer id);
    
}
