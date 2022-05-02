package com.example.repository;

import com.example.model.Chamis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamisRepository extends JpaRepository<Chamis, String> {
    
    public Chamis findByEmail(String email);

    public Chamis findByLogin(String login);

}