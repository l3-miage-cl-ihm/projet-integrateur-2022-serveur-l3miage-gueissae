package com.example.ControllerEtService.Prologue;

import java.util.List;

import com.example.model.Materiel;
import com.example.model.Prologue;
import com.example.repository.MaterielRepository;
import com.example.repository.PrologueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrologueService {
    
    private final PrologueRepository prologueRepository;
    private final MaterielRepository materielRepository;

    @Autowired
    public PrologueService(PrologueRepository prologueRepository,MaterielRepository materielRepository){
        this.prologueRepository = prologueRepository;
        this.materielRepository = materielRepository;
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

    public  void deletePrologue(Integer identifiant) {
        Prologue deletedPrologue = prologueRepository.findByIdentifiant(identifiant);
        List<Materiel> materiels = deletedPrologue.getMateriels() ;
        // if (updatedPrologue == null) {
        //    throw new IllegalStateException("prologue not found");
        //}
        deleteMaterielsPrologue(materiels);
        prologueRepository.delete(deletedPrologue);
    }

    public void deleteMaterielsPrologue(List<Materiel> materiels){
        for (Materiel materiel : materiels) {
            materielRepository.delete(materiel);
        }
    }

}
