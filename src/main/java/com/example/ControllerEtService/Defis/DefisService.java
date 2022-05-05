package com.example.ControllerEtService.Defis;

import java.util.List;

import com.example.model.Chamis;
import com.example.model.Defis;
import com.example.model.Epilogue;
import com.example.model.Etape;
import com.example.model.Indice;
import com.example.model.Information;
import com.example.model.Materiel;
import com.example.model.MotCle;
import com.example.model.Prologue;
import com.example.model.Question;
import com.example.model.Reponse;
import com.example.model.Visite;
import com.example.repository.ChamisRepository;
import com.example.repository.DefisRepository;
import com.example.repository.EpilogueRepository;
import com.example.repository.EtapeRepository;
import com.example.repository.IndiceRepository;
import com.example.repository.InformationRepository;
import com.example.repository.MaterielRepository;
import com.example.repository.MotCleRepository;
import com.example.repository.PrologueRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.ReponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefisService {

    private final DefisRepository defisRepository;
    private final ChamisRepository chamisRepository;
    private final MotCleRepository motCleRepository;
    private final EtapeRepository etapeRepository;
    private final PrologueRepository prologueRepository;
    private final EpilogueRepository epilogueRepository;
    private final MaterielRepository materielRepository;
    private final ReponseRepository reponseRepository;
    private final QuestionRepository questionRepository;
    private final IndiceRepository indiceRepository;
    private final InformationRepository informationRepository;

    @Autowired
    public DefisService(DefisRepository defisRepository, ChamisRepository chamisRepository,
            MotCleRepository motCleRepository,EtapeRepository etapeRepository, PrologueRepository prologueRepository,EpilogueRepository  epilogueRepository
            ,MaterielRepository materielRepository, ReponseRepository reponseRepository, QuestionRepository questionRepository, IndiceRepository indiceRepository,
            InformationRepository informationRepository) {
        this.defisRepository = defisRepository;
        this.chamisRepository = chamisRepository;
        this.motCleRepository = motCleRepository;
        this.etapeRepository=etapeRepository;
        this.prologueRepository = prologueRepository;
        this.epilogueRepository= epilogueRepository;
        this.materielRepository = materielRepository;
        this.reponseRepository = reponseRepository;
        this.questionRepository = questionRepository;
        this.indiceRepository = indiceRepository;
        this.informationRepository = informationRepository;
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
    public void deleteDefis(String  idDefi){
        Defis deleteDefis = defisRepository.findById(idDefi).orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        List<Visite> listeVisites = deleteDefis.getVisites();
        List<Etape> listeEtapes = deleteDefis.getEtapes();
        Prologue prologue = deleteDefis.getPrologue();
        Epilogue epilogue = deleteDefis.getEpilogue();
        
        if(listeVisites==null){// SI LE DEFI N'A PAS DE VISITE
            deleteEtapeDefis(listeEtapes); 
            deletePrologueDefis(prologue);
            deleteEpilogueDefis(epilogue);       
            defisRepository.delete(deleteDefis);
        } else {
            deleteDefis.setActif(false);
        }
    }
    
    public void deleteEtapeDefis(List<Etape> etapes){
        for (Etape etape : etapes) {
            if(etape instanceof Question){
                deleteQuestionDefis((Question)etape);
            }
            if(etape instanceof Information){
                deleteInformationDefis((Information)etape);
            }
            etapeRepository.delete(etape);
        }
    }
    private void deleteInformationDefis(Information question) {
        List<Indice> indices =question.getIndices();
        deleteIndicesDefis(indices);
        informationRepository.delete(question);
    }

    private void deleteQuestionDefis(Question etape) {
        List<Reponse> reponses = etape.getReponses();
        List<Indice> indices = etape.getIndices();
        deleteIndicesDefis(indices);
        deleteReponsesDefis(reponses);
        questionRepository.delete(etape);
    }

    private void deleteIndicesDefis(List<Indice> indices) {
        for (Indice indice : indices) {
            indiceRepository.delete(indice);
        }
    }

    private  void deleteReponsesDefis(List<Reponse> reponses){
        for (Reponse reponse : reponses) {
            reponseRepository.delete(reponse);
        }
    }

    public void deletePrologueDefis(Prologue prologue){
        List<Materiel> listMaterielPrologue = prologue.getMateriels();
        deleteMaterielDefis(listMaterielPrologue);
        prologueRepository.delete(prologue);
    }

    public void deleteEpilogueDefis(Epilogue epilogue){
        List<Materiel> listMaterielEpilogue = epilogue.getMateriels();
        deleteMaterielDefis(listMaterielEpilogue);
        epilogueRepository.delete(epilogue);
    }

    public void deleteMaterielDefis(List<Materiel> materiels){
        for (Materiel materiel : materiels) {
            materielRepository.delete(materiel);
        }
    }
}

