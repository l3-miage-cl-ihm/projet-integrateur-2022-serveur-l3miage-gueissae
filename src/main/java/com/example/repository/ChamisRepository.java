package com.example.repository;

import java.util.List;

import com.example.model.Chamis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamisRepository extends JpaRepository<Chamis, String> {
    List<Chamis> findByEmail(String email);
}