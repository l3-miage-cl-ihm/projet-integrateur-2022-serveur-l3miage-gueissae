package com.example.repository;

import com.example.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    public Question findByIdentifiant(Integer identifiant);
}
