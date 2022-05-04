package com.example.repository;

import com.example.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    public Image findByIdentifiant(Integer identifiant);
}
