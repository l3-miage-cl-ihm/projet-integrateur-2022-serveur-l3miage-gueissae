// package com.example.datas;

// import java.util.ArrayList;
// import java.util.List;

// import com.example.enumeration.*;
// import com.example.model.*;
// import com.example.repository.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// @Component
// public class DataLoader {

//     private ChamisRepository chamisRepository;
//     private VilleRepository villeRepository;
//     private DefisRepository defisRepository;
//     private VisiteRepository visiteRepository;
//     private EpilogueRepository epilogueRepository;
//     private MaterielRepository materielRepository;
//     private PrologueRepository prologueRepository;
//     private MotCleRepository motCleRepository;
//     private IndiceRepository indiceRepository;
//     private ReponseRepository reponseRepository;
//     private EtapeRepository etapeRepository;
//     private QuestionRepository questionRepository;
//     private TexteRepository texteRepository;

//     @Autowired
//     public DataLoader(ChamisRepository chamisRepository, VilleRepository villeRepository,
//             DefisRepository defisRepository, VisiteRepository visiteRepository, EpilogueRepository epilogueRepository,
//             MaterielRepository materielRepository, PrologueRepository prologueRepository,
//             MotCleRepository motCleRepository, IndiceRepository indiceRepository,
//             ReponseRepository reponseRepository, EtapeRepository etapeRepository, TexteRepository texteRepository) {
//         this.chamisRepository = chamisRepository;
//         this.villeRepository = villeRepository;
//         this.defisRepository = defisRepository;
//         this.visiteRepository = visiteRepository;
//         this.epilogueRepository = epilogueRepository;
//         this.materielRepository = materielRepository;
//         this.prologueRepository = prologueRepository;
//         this.motCleRepository = motCleRepository;
//         this.indiceRepository = indiceRepository;
//         this.reponseRepository = reponseRepository;
//         this.etapeRepository = etapeRepository;
//         this.texteRepository = texteRepository;
//         LoadTexte();
//         LoadEpilogue();
//         LoadPrologue();
//         LoadMotsCles();
//         LoadIndices();
//         LoadReponses();
//         LoadQuestions();
//         LoadVisites();
//         LoadDefis();
//         LoadVille();
//         LoadChamis();
//     }

//     private void LoadTexte() {
//         Texte textePro = new Texte(1, "texte du prologue");
//         Texte texteEpi = new Texte(2, "texte de l'épilogue.");
//         texteRepository.save(textePro);
//         texteRepository.save(texteEpi);
//     }

//     private void LoadPrologue() {
//         Materiel materiel = materielRepository.getById(1);
//         List<Materiel> materiels = new ArrayList<Materiel>();
//         materiels.add(materiel);
//         Prologue prologue = new Prologue(materiels);
//         prologueRepository.save(prologue);
//     }

//     private void LoadEpilogue() {
//         Materiel materiel = materielRepository.getById(2);
//         List<Materiel> materiels = new ArrayList<Materiel>();
//         materiels.add(materiel);
//         Epilogue epilogue = new Epilogue(materiels);
//         epilogueRepository.save(epilogue);
//     }

//     private void LoadMotsCles() {
//         MotCle mot1 = new MotCle("test1");
//         MotCle mot2 = new MotCle("test2");
//         motCleRepository.save(mot1);
//         motCleRepository.save(mot2);
//     }

//     private void LoadIndices() {
//         Indice indice1 = new Indice("très", "cet question est très très", 1);
//         Indice indice2 = new Indice("difficile", "difficle vraiment", 1);
//         indiceRepository.save(indice1);
//         indiceRepository.save(indice2);
//     }

//     private void LoadReponses(){
//         Texte texte1 = new Texte(1,"réponse A");
//         Texte texte2 = new Texte(2,"réponse B");
//         Texte texte3 = new Texte(3,"réponse C");
//         Texte texte4 = new Texte(4,"réponse D");
//         Reponse reponse1 = new Reponse(texte1, false);
//         Reponse reponse2 = new Reponse(texte2, false);
//         Reponse reponse3 = new Reponse(texte3, false);
//         Reponse reponse4 = new Reponse(texte4, true);
//         reponseRepository.save(reponse1);
//         reponseRepository.save(reponse2);
//         reponseRepository.save(reponse3);
//         reponseRepository.save(reponse4);
//     }

//     private void LoadQuestions() {
//         List<Indice> indiceEtapes = indiceRepository.findAll();
//         List<Reponse> reponseList = reponseRepository.findAll();
//         Question question1 = new Question(1, "question1", "première question ?", reponseList, indiceEtapes);
//         questionRepository.save(question1);
//     }

//     private void LoadVisites() {
//         Mode modeVisite = Mode.PRESENTIEL;
//         Statut statutVisite = Statut.ENCOURS;
//         List<Repondre> repondre = new ArrayList<Repondre>();
//         List<Indice> indiceVisite = indiceRepository.findAll();
//         Visite visite1 = new Visite("03/05/2022", "13:41", modeVisite, statutVisite, 4, 999, "difficile", repondre,
//                 indiceVisite);
//         visiteRepository.save(visite1);
//     }

//     private void LoadDefis() {
//         Type typeDefi = Type.CHALLENGE;
//         Mode modeDefi = Mode.PRESENTIEL;
//         List<Visite> visitesVoulues = visiteRepository.findAll();
//         List<Etape> etapesVoulues = etapeRepository.findAll(); // à voir, ptet un bug
//         // List<Question> questionsVoulues = questionRepository.findAll();
//         Prologue prologue = prologueRepository.findByIdentifiant(1);
//         Epilogue epilogue = epilogueRepository.findByIdentifiant(1);
//         List<MotCle> motsClesDefis = motCleRepository.findAll();
//         Defis defi = new Defis("bonjour", "premier défi !!", typeDefi, modeDefi, 5, 900, "aucuns.", "02/05/2022",
//                 "02/05/2022", visitesVoulues, prologue, epilogue, etapesVoulues/*questionsVoulues*/ , motsClesDefis);
//         defisRepository.save(defi);
//     }

//     private void LoadVille() {
//         Ville grenoble = new Ville("grenoble");
//         villeRepository.save(grenoble);
//     }

//     private void LoadChamis() {
//         Ville villeVoulue = villeRepository.getById(1);
//         List<Defis> defisVoulus = null;
//         List<Visite> visitesVoulues = null;
//         chamisRepository.save(
//                 new Chamis("justin.goudon@outlook.fr", "goudonju", 21, "a", villeVoulue, defisVoulus, visitesVoulues));
//     }
// }

package com.example.datas;

import java.util.List;

import com.example.enumeration.*;
import com.example.model.*;
import com.example.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private ChamisRepository chamisRepository;
    private VilleRepository villeRepository;
    private DefisRepository defisRepository;
    private VisiteRepository visiteRepository;

    @Autowired
    public DataLoader(ChamisRepository chamisRepository, VilleRepository villeRepository, DefisRepository defisRepository, VisiteRepository visiteRepository) {
        this.chamisRepository = chamisRepository;
        this.villeRepository = villeRepository;
        this.defisRepository = defisRepository;
        this.visiteRepository = visiteRepository;
        LoadVille();
        //LoadVisites();
        LoadDefis();
        LoadChamis();
    }

    private void LoadVille(){
        Ville grenoble = new Ville("grenoble");
        villeRepository.save(grenoble);
    }

    // private void LoadVisites(){
    //     Visite visite1 = new Visite();
    //     visiteRepository.save(visite1);
    // }

    private void LoadDefis(){
        Type typeDefi = Type.CHALLENGE;
        Mode modeDefi = Mode.PRESENTIEL;
        List<Visite> visitesVoulues = null; 
        List<Etape> etapesVoulues = null;
        Prologue prologue = null;
        Epilogue epilogue = null;
        List<MotCle> motsClesDefis = null;
        Defis defi = new Defis("bonjour","premier défi !!", typeDefi,modeDefi,5,900,"aucuns.","02/05/2022","02/05/2022",visitesVoulues,prologue,epilogue,etapesVoulues,motsClesDefis);
        defisRepository.save(defi);
    }

    private void LoadChamis() {
        Ville villeVoulue = villeRepository.getById(1);
        List<Defis> defisVoulus = null;
        List<Visite> visitesVoulues = null;
        chamisRepository.save(new Chamis("justin.goudon@outlook.fr", "goudonju", 21,"a",villeVoulue,defisVoulus,visitesVoulues));
    }
}