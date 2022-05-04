package com.example.repository;

import com.example.model.Texte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TexteRepository extends JpaRepository<Texte, Integer> {
    public Texte findByIdentifiant(Integer identifiant);
}