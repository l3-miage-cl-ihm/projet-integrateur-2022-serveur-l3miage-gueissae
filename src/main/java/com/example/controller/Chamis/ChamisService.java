package com.example.controller.Chamis;

import java.util.List;

import com.example.model.Chamis;
import com.example.repository.ChamisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChamisService {
    
    private final ChamisRepository chamisRepository;

    @Autowired
    public ChamisService(ChamisRepository chamisRepository) {
        this.chamisRepository = chamisRepository;
    }

    public List<Chamis> getAllChamis() {
        return chamisRepository.findAll();
    }

    public void addNewChamis(Chamis chamis) {
        chamisRepository.save(chamis);           
    }

    public Chamis findByEmail(String email) {
        return chamisRepository.findByEmail(email);
    }
}