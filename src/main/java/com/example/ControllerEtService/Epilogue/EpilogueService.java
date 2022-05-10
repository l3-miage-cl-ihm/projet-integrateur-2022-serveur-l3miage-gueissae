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

    // TODO: unused
    public List<Epilogue> getAllEpilogues() {
        return epilogueRepository.findAll();
    }

    /**
     * Permet d'ajouter un épilogue à la base de données grâce à la fonction
     * save de epilogueRepository implémentée par SpringBoot.
     * 
     * @param epilogue L'épilogue que l'on veux utiliser.
     * @return void
     */
    public void addNewEpilogue(Epilogue epilogue){
        epilogueRepository.save(epilogue);
    }

    /**
     * Permet de trouver un épilogue dans la base de données grâce à son
     * id et en utilisant la fonction findByIdentifiant de epilogueRepository
     * implémentée par SpringBoot.
     * 
     * @param id L'identifiant de l'épilogue que l'on recherche.
     * @return L'épilogue que l'on recherche.
     */
    public Epilogue findByIdentifiant(Integer id){
        return epilogueRepository.findByIdentifiant(id);
    }

    /**
     * Permet de mettre à jour l'épilogue que l'on veux dans la base de données.
     * On va d'abord chercher l'épilogue que l'on veux
     * 
     * 
     * @param epilogue L'épilogue que l'on veux mettre à jour.
     * @return L'épilogue mis à jour.
     */
    public Epilogue updateEpilogue(Epilogue epilogue) {
        Epilogue  updatedEpilogue = findByIdentifiant(epilogue.getIdentifiant());
        if (updatedEpilogue==null){
            throw new IllegalStateException("epilogue not found");
        }
        updatedEpilogue.setMateriels(epilogue.getMateriels());
        epilogueRepository.save(updatedEpilogue);
        return updatedEpilogue;
    }

    // TODO : gestion d'erreurs
    
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
