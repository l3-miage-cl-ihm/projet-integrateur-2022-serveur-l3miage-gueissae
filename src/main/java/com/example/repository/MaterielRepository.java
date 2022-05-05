package com.example.repository;

import com.example.model.Materiel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielRepository extends JpaRepository<Materiel, Integer> {

    public Materiel findByIdentifiant(Integer identifiant);

}
