package com.example.repository;

import com.example.model.Prologue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrologueRepository extends JpaRepository<Prologue, String> {
}