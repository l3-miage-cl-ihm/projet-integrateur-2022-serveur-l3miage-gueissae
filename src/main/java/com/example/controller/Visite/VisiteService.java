package com.example.controller.Visite;

import java.util.List;

import com.example.model.Visite;
import com.example.repository.VisiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisiteService {

    private final VisiteRepository visiteRepository;

    @Autowired
    public VisiteService(VisiteRepository VisiteRepository){
        this.visiteRepository = VisiteRepository;
    }

    public List<Visite> getAllVisites(){
        return visiteRepository.findAll();
    }

    public void addNewVisite(Visite Visite){
        visiteRepository.save(Visite);
    }

    public Visite findByIdentifiant(Integer id){
        return visiteRepository.findByIdentifiant(id);
    }
}
