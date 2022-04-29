package com.example.repository;

import java.util.List;

import com.example.model.MotCle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MotCleRepository extends JpaRepository<MotCle, String> {

    public MotCle findByMot(String mot);

    @Query("SELECT mots FROM MotCle mots WHERE mots.mot LIKE ?1%")
    List<MotCle> findByPrefix(String prefix);

}