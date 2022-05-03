package com.example.repository;

import com.example.model.Repondre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepondreRepository extends JpaRepository<Repondre, Integer> {
    public Repondre findByIdentifiant(Integer identifiant);
}