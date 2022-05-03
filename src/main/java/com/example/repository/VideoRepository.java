package com.example.repository;

import com.example.model.Video;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {
    public Video findByIdentifiant(Integer identifiant);
}