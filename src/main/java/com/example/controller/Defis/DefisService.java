package com.example.controller.Defis;

import java.util.List;
import java.util.Optional;

import com.example.model.Defis;
import com.example.repository.DefisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Defis addNewDefis(Defis defis) {
        return defisRepository.save(defis);
    }
    @Transactional
    public Defis updateDefis(  Defis defi) {
        String id = defi.getIdentifiant() ;
        Defis updatedDefi = defisRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Defis not found")); ;
        updatedDefi.setTitre(defi.getTitre());
        updatedDefi.setDescription(defi.getDescription());
        updatedDefi.setType(defi.getType());
        updatedDefi.setDistanciel(defi.getDistanciel());
        updatedDefi.setPoint(defi.getPoint());
        updatedDefi.setDuree(defi.getDuree());
        updatedDefi.setCommentaire(defi.getCommentaire());
        updatedDefi.setDateDeCreation(defi.getDateDeCreation());
        updatedDefi.setDateDeModification(defi.getDateDeModification());
       
        updatedDefi.setMotsCles(defi.getMotsCles());
        //updatedDefi.setArret(defi.getArret());
        updatedDefi.setPrologue(defi.getPrologue());
        updatedDefi.setEpilogue(defi.getEpilogue());
        updatedDefi.setEtapes(defi.getEtapes());
        updatedDefi.setVisites(defi.getVisites());

        return updatedDefi;

    }
    
}
