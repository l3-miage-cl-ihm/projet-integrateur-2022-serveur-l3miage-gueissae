package com.example.controller.Etape;

import java.util.List;

import com.example.model.Etape;
import com.example.repository.EtapeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapeService {
    
    private final EtapeRepository etapeRepository;

    @Autowired
    public EtapeService(EtapeRepository etapeRepository){
        this.etapeRepository = etapeRepository;
    }

    public List<Etape> getAllEtapes(){
        return etapeRepository.findAll();
    }

    public void addNewEtape(Etape etape){
        etapeRepository.save(etape);
    }

    public Etape findByIdentifiant(Integer id){
        return etapeRepository.findByIdentifiant(id);
    }
}
