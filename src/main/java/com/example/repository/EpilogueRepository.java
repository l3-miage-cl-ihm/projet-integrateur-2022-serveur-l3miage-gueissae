package com.example.repository;

import com.example.model.Epilogue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EpilogueRepository extends JpaRepository<Epilogue, Integer> {

    public Epilogue findByIdentifiant(Integer identifiant);
}
