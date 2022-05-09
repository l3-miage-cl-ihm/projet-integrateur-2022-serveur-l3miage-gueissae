package com.example.ControllerEtService.Chamis;

import java.util.List;

import javax.transaction.Transactional;

import com.example.model.Chamis;
import com.example.repository.ChamisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamisService {
    
    private final ChamisRepository chamisRepository;

    @Autowired
    public ChamisService(ChamisRepository chamisRepository) {
        this.chamisRepository = chamisRepository;
    }

    public List<Chamis> getAllChamis() {
        return chamisRepository.findAll();
    }

    public void addNewChamis(Chamis chamis) {
        chamisRepository.save(chamis);           
    }

    public Chamis findByEmail(String email) {
        return chamisRepository.findByEmail(email);
    }

    public Chamis findByLogin(String login) {
        return chamisRepository.findByLogin(login);
    }

    @Transactional
    public Chamis  updateChamis(Chamis  chamis){
        String email = chamis.getEmail();
        Chamis updatedChamis = chamisRepository.findByEmail(email);
        if(updatedChamis==null){
            throw new IllegalStateException("Chamis with email:"+email+" doesn't exists");
        }
        updatedChamis.setAge(chamis.getAge());
        updatedChamis.setDefis(chamis.getDefis());
        updatedChamis.setDescription(chamis.getDescription());
        updatedChamis.setLogin(chamis.getLogin());
        updatedChamis.setVille(chamis.getVille());
        updatedChamis.setVisites(chamis.getVisites());
        return updatedChamis;
    }

    public void deleteChamisByEmail(String mail) {
        Chamis hiddenChamis = chamisRepository.findByEmail(mail);
        if(hiddenChamis==null){
            throw new IllegalArgumentException("chamis not found");
        }
        hiddenChamis.setActive(false);
    }
}
