package com.example.controller.Materiel;

import java.util.List;

import com.example.model.Materiel;
import com.example.repository.MaterielRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielService {

    private final MaterielRepository materielRepository;

    @Autowired
    public MaterielService(MaterielRepository materielRepository){
        this.materielRepository = materielRepository;
    }

    public List<Materiel> getAllMateriels(){
        return materielRepository.findAll();
    }

    public void addNewMateriel(Materiel materiel){
        materielRepository.save(materiel);
    }

    public Materiel findByIdentifiant(Integer id){
        return materielRepository.findByIdentifiant(id);
    }
}
