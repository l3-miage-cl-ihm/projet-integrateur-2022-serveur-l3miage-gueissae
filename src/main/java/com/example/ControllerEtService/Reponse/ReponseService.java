package com.example.ControllerEtService.Reponse;

import java.util.List;

import com.example.model.Materiel;
import com.example.model.Reponse;
import com.example.repository.MaterielRepository;
import com.example.repository.ReponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {

    private final ReponseRepository reponseRepository;
    private final MaterielRepository materielRepository;


    @Autowired
    public ReponseService(ReponseRepository reponseRepository, MaterielRepository materielRepository){
        this.reponseRepository = reponseRepository;
        this.materielRepository = materielRepository;
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

    public void deleteReponseById(Integer id) {
        Reponse reponse = findByIdentifiant(id);
        if(reponse==null){
            throw new IllegalArgumentException("reponse not found");
        } else {
            Materiel reponseMat = reponse.getMateriel();
            materielRepository.delete(reponseMat);
            reponseRepository.delete(reponse);
        }
    }
}
