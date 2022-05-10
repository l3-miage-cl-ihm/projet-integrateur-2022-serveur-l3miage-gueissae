package com.example.ControllerEtService.Defis;

import java.util.List;

import com.example.ControllerEtService.Information.InformationService;
import com.example.ControllerEtService.Question.QuestionService;
import com.example.model.Arret;
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
import com.example.repository.ArretRepository;
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

    // TODO: commentaires et clean up

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
    private final QuestionService questionService;
    private final ArretRepository arretRepository;
    private final  InformationService  informationService;

    @Autowired
    public DefisService(DefisRepository defisRepository, ChamisRepository chamisRepository,
            MotCleRepository motCleRepository,EtapeRepository etapeRepository, PrologueRepository prologueRepository,EpilogueRepository  epilogueRepository
            ,MaterielRepository materielRepository, ReponseRepository reponseRepository, QuestionRepository questionRepository, IndiceRepository indiceRepository,
            InformationRepository informationRepository, QuestionService questionService, ArretRepository arretRepository,   InformationService informationService) {
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
        this.questionService = questionService;
        this.arretRepository = arretRepository;
        this.informationService= informationService;
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
        for(Etape e : defi.getEtapes()){
   
            if(e instanceof Question){
                Question q = (Question)e;
                questionService.updateQuestion(q);                
            }
            if(e instanceof Information){
                Information i = (Information)e;
                informationService.updateInformation(i);
            }
        }
        updatedDefi.setVisites(defi.getVisites());
     
        System.out.println("coucocu   1");
        // System.out.println("coucocu   id : " +  defi.getArret().getIdentifiant());
        // ne rentre pas dans coucouc 2 quand il le faut 
        if(updatedDefi.getArret() != null && defi.getArret() != null){
            System.out.println("coucocu     2");

            if(updatedDefi.getArret().getIdentifiant() != defi.getArret().getIdentifiant()){
                System.out.println("les deux arret sont différent donc update");
               Arret arret = arretRepository.findByIdentifiant(defi.getArret().getIdentifiant());
               //Arret oldArret = updatedDefi.getArret();
               // lors du changement d'arret la liaison entre defis et arret dans la trable les_arrets_defis n'est pas supprimé
               // oldArret.DeleteDefis(updatedDefi);
               arretRepository.deletedefisarrets(updatedDefi.getArret().getIdentifiant(), updatedDefi.getIdentifiant());
               arret.addDefis(updatedDefi);
               updatedDefi.setArret(arret);

         
            }

        }else if(defi.getArret() != null){
            System.out.println("coucocu 3");

            Arret arret = arretRepository.findByIdentifiant(defi.getArret().getIdentifiant());
            arret.addDefis(updatedDefi);
            updatedDefi.setArret(arret);
            // updatedDefi.setArret(arret);
        }
        return updatedDefi;
    }
/**
* Ajoute un motclé dans la liste d'un défi
* 
* Cette  méthode recherche le mot en utilisant le label de ce dernier
* pour ensuite l'ajouter à la liste du défi qui sera renseigné par son id.
* Ce faisant nous renverrons le défi modifiées. 
*
* @param  mot  le label du mot à ajouter au défi
* @param  idDefi  l'identifiant du défi auquel on va ajouter le mot 
* @return  updatedDefi : le defi avec le motclé ajouter a la liste 
* @see   Defis
*/
    @Transactional
    public Defis addMotCleDefis(String mot, String idDefi) {
        MotCle motCle = motCleRepository.findByMot(mot);
        Defis updatedDefi = defisRepository.findById(idDefi)
                .orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        updatedDefi.addMotCle(motCle);
        return updatedDefi;
    }
/**
* Retire un motclé de la liste d'un défi
* 
* Cette  méthode recherche le mot en utilisant le label de ce dernier
* pour ensuite le retirer à la liste du défi qui sera renseigné par son id.
* Ce faisant nous renverrons le défi modifiés. 
*
* @param  mot  le label du mot à retirer au défi
* @param  idDefi  l'identifiant du défi auquel on va retirer le mot 
* @return  updatedDefi : le defi avec le motclé retirer a la liste 
* @see   Defis
*/
    @Transactional
    public Defis removeMotCleDefis(String mot, String idDefi) {
        MotCle motCle = motCleRepository.findByMot(mot);
        Defis updatedDefi = defisRepository.findById(idDefi)
                .orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        updatedDefi.suppressMotCle(motCle);
        return updatedDefi;
    }

/**
* Retire un défi ainsi que tout ce qui est lié uniquement à ce défi dans la base de donnée
* si ce dernier n'a aucune visite, sinon on le cache en changeant son attribut actif
* 
* Cette  méthode recherche le défi que nous souhaitons rétirer de la base 
* à l'aide de son identifiant. Pour ensuite recupérer  son prologue, son épilogue,la liste
* des visites et enfin la liste des étapes. On vérifie deja si la liste des visites est vides.
* Si la liste est vides, on fait appel aux fonctions annexes pour supprimer la listes des étapes ainsi 
* que tout se qui est lié aux étapes, le prologue et l'epilogue et tout le matériel lié à ces objets.
* Si la liste des visites n'est pas vide, on modifie simplement la valeur de l'attibut actif du défi
*en le passant en false pour le cacher.
*
* @param  idDefi  l'identifiant du défi qu'on veut supprimer de la base
* @return  void on en retourne rien
* @see   Defis
*/
    @Transactional
    public void deleteDefis(String idDefi){
        System.out.println("Défis 1 Service");
        System.out.println("L'id :::::::::::::::::::: "+idDefi);
        Defis deleteDefis = defisRepository.findById(idDefi).orElseThrow(() -> new IllegalArgumentException("Defis not found"));
        System.out.println("Défis 1.2 Service");
        List<Visite> listeVisites = deleteDefis.getVisites();
        List<Etape> listeEtapes = deleteDefis.getEtapes();
        Prologue prologue = deleteDefis.getPrologue();
        Epilogue epilogue = deleteDefis.getEpilogue();
        System.out.println("Défis 2 Service");
        
        if(listeVisites.size() ==0){
            System.out.println("Défis 3 Service");
            deleteEtapeDefis(listeEtapes); 
            deletePrologueDefis(prologue);
            deleteEpilogueDefis(epilogue);       
            defisRepository.delete(deleteDefis);
        } else {
            System.out.println("Défis 4 Service");
            System.out.println("Etat d'activité du défis de la fct avant modif"+deleteDefis.getActif());
            deleteDefis.setActif();
            // defisRepository.save(deleteDefis);
            System.out.println("Etat d'activité du défis de la fct après modif"+deleteDefis.getActif());
            Defis defi = defisRepository.findById(deleteDefis.getIdentifiant()).get();
            System.out.println("Défis 5 Service, Etat d'activité du défi récup après modif "+defi.getActif());
        }
    }
/**
* Supprime les étapes d'un défi en supprimant
* 
* Cette  méthode recherche le mot en utilisant le label de ce dernier
* pour ensuite le retirer à la liste du défi qui sera renseigné par son id.
* Ce faisant nous renverrons le défi modifiés. 
*
* @param  mot  le label du mot à retirer au défi
* @param  idDefi  l'identifiant du défi auquel on va retirer le mot 
* @return  updatedDefi : le defi avec le motclé retirer a la liste 
* @see   Defis
*/
    public void deleteEtapeDefis(List<Etape> etapes){
        for (Etape etape : etapes) {
            if(etape instanceof Question){
                System.out.println("Le if question de deleteEtapeDefis");
                deleteQuestionDefis((Question)etape);
            }
            if(etape instanceof Information){
                System.out.println("Le if information de deleteEtapeDefis");
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

