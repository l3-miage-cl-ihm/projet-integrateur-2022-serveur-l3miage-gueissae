package com.example.ControllerEtService.Indice;

import java.util.List;

import com.example.model.Indice;
import com.example.repository.IndiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiceService {

    private final IndiceRepository indiceRepository;

    @Autowired
    public IndiceService(IndiceRepository indiceRepository){
        this.indiceRepository = indiceRepository;
    }

    public List<Indice> getAllIndices() {
        return indiceRepository.findAll();
    }

    public void addNewIndice(Indice indice){
        indiceRepository.save(indice);
    }

    public Indice findByIdentifiant(Integer id){
        return indiceRepository.findByIdentifiant(id);
    }
    public void deleteIndiceById(Integer identifiant){
        Indice deletedIndice = indiceRepository.findByIdentifiant(identifiant);
        indiceRepository.delete(deletedIndice);
    }
}
