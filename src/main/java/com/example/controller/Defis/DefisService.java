package com.example.controller.Defis;

import java.util.List;

import com.example.model.Defis;
import com.example.repository.DefisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefisService {
    
    private final DefisRepository defisRepository;

    @Autowired
    public DefisService(DefisRepository defisRepository) {
        this.defisRepository = defisRepository;
    }

    public List<Defis> getAllDefis() {
        return defisRepository.findAll();
    }

    public void addNewDefis(Defis defis) {
        defisRepository.save(defis);           
    }
    
}
