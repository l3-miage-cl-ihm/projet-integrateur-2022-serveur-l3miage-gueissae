package com.example.ControllerEtService.Epilogue;

import java.util.List;

import com.example.model.Epilogue;
import com.example.model.Materiel;
import com.example.repository.EpilogueRepository;
import com.example.repository.MaterielRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EpilogueService {
    
    private final EpilogueRepository epilogueRepository;
    private final MaterielRepository materielRepository;

    @Autowired
    public EpilogueService(EpilogueRepository epilogueRepository,MaterielRepository materielRepository) {
        this.epilogueRepository = epilogueRepository;
        this.materielRepository = materielRepository;
    }

    public List<Epilogue> getAllEpilogues() {
        return epilogueRepository.findAll();
    }

    public void addNewEpilogue(Epilogue epilogue){
        epilogueRepository.save(epilogue);
    }

    public Epilogue findByIdentifiant(Integer id){
        return epilogueRepository.findByIdentifiant(id);
    }
    public Epilogue updateEpilogue(Epilogue epilogue) {
        Epilogue  updatedEpilogue = epilogueRepository.findByIdentifiant(epilogue.getIdentifiant());
        if (updatedEpilogue==null){
            throw new IllegalStateException("epilogue not found");
        }
        updatedEpilogue.setMateriels(epilogue.getMateriels());
        epilogueRepository.save(updatedEpilogue);
        return updatedEpilogue;
    }

    
    // TO DO : gestion d'erreurs
    
    public  void deleteEpilogue(Integer identifiant) {
        Epilogue deletedEpilogue = epilogueRepository.findByIdentifiant(identifiant);
        List<Materiel> materiels = deletedEpilogue.getMateriels() ;
        deleteMaterielsEpilogue(materiels);
        epilogueRepository.delete(deletedEpilogue);
    }

    public void deleteMaterielsEpilogue(List<Materiel> materiels){
        for (Materiel materiel : materiels) {
            materielRepository.delete(materiel);
        }
    }
}
