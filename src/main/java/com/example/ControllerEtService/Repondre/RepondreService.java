package com.example.ControllerEtService.Repondre;

import java.util.List;

import com.example.model.Repondre;
import com.example.repository.RepondreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepondreService {

    private final RepondreRepository repondreRepository;

    @Autowired
    public RepondreService(RepondreRepository repondreRepository){
        this.repondreRepository = repondreRepository;
    }

    public List<Repondre> getAllRepondres(){
        return repondreRepository.findAll();
    }

    public void addNewRepondre(Repondre repondre){
        repondreRepository.save(repondre);
    }

    public Repondre findByIdentifiant(Integer id){
        return repondreRepository.findByIdentifiant(id);
    }

    public Repondre updateRepondre(Repondre repondre) {
        Repondre updatedRepondre =  repondreRepository.findByIdentifiant(repondre.getIdentifiant());
        updatedRepondre.setPoint(repondre.getPoint());
        repondreRepository.save(updatedRepondre);
        return updatedRepondre;
    }
}
