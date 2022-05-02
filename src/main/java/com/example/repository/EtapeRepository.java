package com.example.repository;

import com.example.model.Etape;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapeRepository extends JpaRepository<Etape, Integer> {

    public Etape findByIdentifiant(Integer identifiant);
}