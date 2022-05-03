package com.example.controller.Ville;

import java.util.List;

import com.example.model.Ville;
import com.example.repository.VilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
    
    private final VilleRepository villeRepository;

    @Autowired
    public VilleService(VilleRepository villeRepository){
        this.villeRepository = villeRepository;
    }

    public List<Ville> getAllVilles(){
        return villeRepository.findAll();
    }

    public void addNewVille(Ville ville){
        villeRepository.save(ville);
    }

    public Ville findByIdentifiant(Integer id){
        return villeRepository.findByIdentifiant(id);
    }
}
