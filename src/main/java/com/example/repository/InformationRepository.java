package com.example.repository;

import com.example.model.Information;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, String> {

    public Information findByIdentifiant(Integer identifiant);
}