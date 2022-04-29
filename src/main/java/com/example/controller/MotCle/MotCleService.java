package com.example.controller.MotCle;

import java.util.List;

import com.example.model.MotCle;
import com.example.repository.MotCleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MotCleService {

    private final MotCleRepository motCleRepository;

    @Autowired
    public MotCleService(MotCleRepository motCleRepository) {
        this.motCleRepository = motCleRepository;
    }

    public List<MotCle> getAllMotsCles() {
        return motCleRepository.findAll();
    }

    public void addNewMotCle(String mot) {
        MotCle motCleTest= motCleRepository.findByMot(mot);
        MotCle motCle = new MotCle(mot) ;


        if(!(motCleTest==null)){
            throw  new  IllegalStateException("Le mot :"+mot+" existe dans la base");  // POUR VOIR LES MESSAGES D'ERREUR FAUT CHANGER APP PROPERTIES
        }else
            motCleRepository.save(motCle);
    }

    public List<MotCle> findWordByPrefix(String prefix) {
        return motCleRepository.findByPrefix(prefix);
    }
}
