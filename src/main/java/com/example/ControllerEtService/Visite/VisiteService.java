package com.example.ControllerEtService.Visite;

import java.util.List;

import com.example.model.Visite;
import com.example.repository.VisiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void updateVisite(Visite visite) {
        Visite updatedVisite = visiteRepository.findByIdentifiant(visite.getIdentifiant());

        
        updatedVisite.setCommentaire(visite.getCommentaire());
        updatedVisite.setDate(visite.getDate());
        updatedVisite.setHeure(visite.getHeure());
        updatedVisite.setMode(visite.getMode());
        updatedVisite.setScore(visite.getScore());
        updatedVisite.setStatut(visite.getStatut());
        updatedVisite.setTemps(visite.getTemps());
    }
}
