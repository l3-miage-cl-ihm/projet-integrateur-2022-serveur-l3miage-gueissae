package com.example.repository;

import com.example.model.Ville;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, String> {
}