package com.example.controller.Reponse;

import java.util.List;

import com.example.model.Reponse;
import com.example.repository.ReponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    private final ReponseRepository reponseRepository;

    @Autowired
    public ReponseService(ReponseRepository reponseRepository){
        this.reponseRepository = reponseRepository;
    }

    public List<Reponse> getAllReponses(){
        return reponseRepository.findAll();
    }

    public void addNewReponse(Reponse reponse){
        reponseRepository.save(reponse);
    }

    public Reponse findByIdentifiant(Integer id){
        return reponseRepository.findByIdentifiant(id);
    }
    
}
