package com.example.ControllerEtService.Information;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.example.model.Information;
import com.example.repository.InformationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
    
    private final InformationRepository informationRepository;

    @Autowired
    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public List<Information> getAllInformations() {
        return informationRepository.findAll();
    }

    public void addNewInformation(Information information){
        informationRepository.save(information);
    }

    public Information findByIdentifiant(Integer id){
        return informationRepository.findByIdentifiant(id);
    }
    public void updateInformation(Information information){
        Information updatedInformation = informationRepository.findByIdentifiant(information.getIdentifiant());
        if (updatedInformation == null){
            throw new IllegalStateException("Information not found");
        }
        updatedInformation.setIndices(information.getIndices());
        updatedInformation.setNumero(information.getNumero());
        updatedInformation.setTexte(information.getTexte());
    }
}
