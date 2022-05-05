package com.example.ControllerEtService.Arret;

import java.util.List;

import com.example.model.Arret;
import com.example.repository.ArretRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArretService {

    private final ArretRepository arretRepository;

    @Autowired
    public ArretService(ArretRepository arretRepository){
        this.arretRepository = arretRepository;
    }

    public List<Arret> getAllArrets(){
        return arretRepository.findAll();
    }

    public void addNewArret(Arret arret){
        arretRepository.save(arret);
    }

    public Arret findByIdentifiant(Integer id){
        return arretRepository.findByIdentifiant(id);
    }

    public Arret updateArret(Arret arret) {
        Arret updatedArret = arretRepository.findByIdentifiant(arret.getId());
        if(updatedArret == null){
            throw new IllegalArgumentException("L'arret avec l'id:" + arret.getId()+"n'existe pas");
        }
        updatedArret.setCode(arret.getCode());
        updatedArret.setNom(arret.getNom());
        updatedArret.setDefis(arret.getDefis());
        updatedArret.setLigne(arret.getLigne());
        return updatedArret;
    }
}
