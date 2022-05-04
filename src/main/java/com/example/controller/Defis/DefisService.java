package com.example.controller.Defis;

import java.util.List;

import com.example.model.Chamis;
import com.example.model.Defis;
import com.example.model.Etape;
import com.example.model.MotCle;
import com.example.model.Question;
import com.example.repository.ChamisRepository;
import com.example.repository.DefisRepository;
import com.example.repository.MotCleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefisService {

    private final DefisRepository defisRepository;
    private final ChamisRepository chamisRepository;
    private final MotCleRepository motCleRepository;

    @Autowired
    public DefisService(DefisRepository defisRepository, ChamisRepository chamisRepository,
            MotCleRepository motCleRepository) {
        this.defisRepository = defisRepository;
        this.chamisRepository = chamisRepository;
        this.motCleRepository = motCleRepository;
    }

    public List<Defis> getAllDefis() {
        return defisRepository.findAll();
    }

    public Defis addNewDefis(String email, Defis defis) {
        Chamis chamis = chamisRepository.findByEmail(email);
        if (chamis != null) {
            chamis.addDefi(defis);
            return defisRepository.save(defis);
        } else {
            throw new Error("Chamis dosn't exist");
        }
    }

    @Transactional
    public Defis updateDefis(Defis defi) {
        String id = defi.getIdentifiant();
        Defis updatedDefi = defisRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        ;
        updatedDefi.setTitre(defi.getTitre());
        updatedDefi.setDescription(defi.getDescription());
        updatedDefi.setType(defi.getType());
        updatedDefi.setMode(defi.getMode());
        updatedDefi.setPoint(defi.getPoint());
        updatedDefi.setDuree(defi.getDuree());
        updatedDefi.setCommentaire(defi.getCommentaire());
        updatedDefi.setDateDeCreation(defi.getDateDeCreation());
        updatedDefi.setDateDeModification(defi.getDateDeModification());

        updatedDefi.setMotsCles(defi.getMotsCles());
        // updatedDefi.setArret(defi.getArret());
        updatedDefi.setPrologue(defi.getPrologue());
        updatedDefi.setEpilogue(defi.getEpilogue());
        updatedDefi.setEtapes(defi.getEtapes());
        // for (Etape e : updatedDefi.getEtapes()) {
        //     if(e instanceof Question){
        //     }
        // }
        updatedDefi.getEtapes();
        updatedDefi.setVisites(defi.getVisites());

        return updatedDefi;

    }

    @Transactional
    public Defis addMotCleDefis(String mot, String idDefi) {
        MotCle motCle = motCleRepository.findByMot(mot);
        Defis updatedDefi = defisRepository.findById(idDefi)
                .orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        updatedDefi.addMotCle(motCle);
        return updatedDefi;
    }

    @Transactional
    public Defis removeMotCleDefis(String mot, String idDefi) {
        MotCle motCle = motCleRepository.findByMot(mot);
        Defis updatedDefi = defisRepository.findById(idDefi)
                .orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        updatedDefi.suppressMotCle(motCle);
        return updatedDefi;
    }
}
