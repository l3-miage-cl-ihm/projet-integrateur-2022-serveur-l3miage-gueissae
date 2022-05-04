package com.example.controller.Prologue;

import java.util.List;

import com.example.model.Prologue;
import com.example.repository.PrologueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrologueService {
    
    private final PrologueRepository prologueRepository;

    @Autowired
    public PrologueService(PrologueRepository prologueRepository){
        this.prologueRepository = prologueRepository;
    }

    public List<Prologue> getAllPrologues(){
        return prologueRepository.findAll();
    }

    public void addNewPrologue(Prologue prologue){
        prologueRepository.save(prologue);
    }

    public Prologue findByIdentifiant(Integer id){
        return prologueRepository.findByIdentifiant(id);
    }

}
