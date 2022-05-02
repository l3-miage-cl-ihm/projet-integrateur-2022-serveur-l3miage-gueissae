package com.example.repository;

import com.example.model.Reponse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {

    public Reponse findByIdentifiant(Integer identifiant);
}
