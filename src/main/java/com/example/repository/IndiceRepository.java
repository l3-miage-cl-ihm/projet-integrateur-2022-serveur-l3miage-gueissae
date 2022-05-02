package com.example.repository;

import com.example.model.Indice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IndiceRepository extends JpaRepository<Indice, Integer> {

    public Indice findByIdentifiant(Integer identifiant);
}
