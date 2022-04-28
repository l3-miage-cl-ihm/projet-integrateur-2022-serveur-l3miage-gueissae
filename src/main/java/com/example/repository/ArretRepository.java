package com.example.repository;

import com.example.model.Arret;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArretRepository extends JpaRepository<Arret, String> {
}