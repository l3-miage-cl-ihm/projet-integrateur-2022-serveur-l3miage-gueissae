package com.example.ControllerEtService.Texte;

import java.util.List;

import com.example.model.Texte;
import com.example.repository.TexteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TexteService {

    private final TexteRepository texteRepository;

    @Autowired
    public TexteService(TexteRepository texteRepository){
        this.texteRepository = texteRepository;
    }

    public List<Texte> getAllTextes(){
        return texteRepository.findAll();
    }

    public void addNewTexte(Texte texte){
        texteRepository.save(texte);
    }

    public Texte findByIdentifiant(Integer id){
        return texteRepository.findByIdentifiant(id);
    }
}
