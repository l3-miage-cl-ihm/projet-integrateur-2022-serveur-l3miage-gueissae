package com.example.datas;

import java.util.ArrayList;
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
    private EpilogueRepository epilogueRepository;
    private MaterielRepository materielRepository;
    private PrologueRepository prologueRepository;
    private MotCleRepository motCleRepository;
    private IndiceRepository indiceRepository;
    private ReponseRepository reponseRepository;
    // private EtapeRepository etapeRepository;
    private QuestionRepository questionRepository;
    private TexteRepository texteRepository;

    @Autowired
    public DataLoader(ChamisRepository chamisRepository, VilleRepository villeRepository,
            DefisRepository defisRepository, VisiteRepository visiteRepository, EpilogueRepository epilogueRepository,
            MaterielRepository materielRepository, PrologueRepository prologueRepository,
            MotCleRepository motCleRepository, IndiceRepository indiceRepository,
            ReponseRepository reponseRepository, EtapeRepository etapeRepository, TexteRepository texteRepository,
            QuestionRepository questionRepository) {
        this.chamisRepository = chamisRepository;
        this.villeRepository = villeRepository;
        this.defisRepository = defisRepository;
        this.visiteRepository = visiteRepository;
        this.epilogueRepository = epilogueRepository;
        this.materielRepository = materielRepository;
        this.prologueRepository = prologueRepository;
        this.motCleRepository = motCleRepository;
        this.indiceRepository = indiceRepository;
        this.reponseRepository = reponseRepository;
        // this.etapeRepository = etapeRepository;
        this.texteRepository = texteRepository;
        this.questionRepository = questionRepository;
        LoadChamis();
    }

    private List<Materiel> LoadMaterielPrologue() {
        Texte textePro = new Texte(1, "texte du prologue");
        List<Materiel> materiels = new ArrayList<Materiel>();
        try {
            materiels.add(textePro);
            texteRepository.save(textePro);
            // materiels.add(texteRepository.save(textePro)); a voir aussi
            // materielRepository.save(textePro); à voir
            return materiels;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les matériels du prologue.");
        }
    }

    private List<Materiel> LoadMaterielEpilogue() {
        Texte texteEpi = new Texte(2, "texte de l'épilogue.");
        List<Materiel> materiels = new ArrayList<Materiel>();
        try {
            materiels.add(texteEpi);
            texteRepository.save(texteEpi);
            // materielRepository.save(texteEpi); à voir
            return materiels;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les matériels de l'épilogue.");
        }
    }

    private Prologue LoadPrologue() {
        Prologue prologue = new Prologue(LoadMaterielPrologue());
        try {
            prologueRepository.save(prologue);
            return prologue;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save le prolog.");
        }
    }

    private Epilogue LoadEpilogue() {
        Epilogue epilogue = new Epilogue(LoadMaterielEpilogue());
        try {
            epilogueRepository.save(epilogue);
            return epilogue;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save l'épilogue.");
        }
    }

    private List<MotCle> LoadMotsCles() {
        MotCle mot1 = new MotCle("test1");
        MotCle mot2 = new MotCle("test2");
        List<MotCle> motCleList = new ArrayList<MotCle>();
        motCleList.add(mot1);
        motCleList.add(mot2);
        try {
            for (MotCle mot : motCleList) {
                motCleRepository.save(mot);
            }
            return motCleList;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les mots clés.");
        }
    }

    private List<Indice> LoadIndices() {
        Indice indice1 = new Indice("très", "cet visite est très très", 1);
        Indice indice2 = new Indice("difficile", "difficle vraiment", 1);
        List<Indice> indices = new ArrayList<Indice>();
        indices.add(indice1);
        indices.add(indice2);
        try {
            for (Indice indice : indices) {
                indiceRepository.save(indice);
            }
            return indices;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les indices.");
        }
    }

    private List<Materiel> LoadTextesReponses() {

        Texte texte1 = new Texte(1, "réponse A");
        Texte texte2 = new Texte(2, "réponse B");
        Texte texte3 = new Texte(3, "réponse C");
        Texte texte4 = new Texte(4, "réponse D");

        List<Materiel> texteList = new ArrayList<Materiel>();
        texteList.add(texte1);
        texteList.add(texte2);
        texteList.add(texte3);
        texteList.add(texte4);

        texteRepository.save(texte1);
        texteRepository.save(texte2);
        texteRepository.save(texte3);
        texteRepository.save(texte4);

                List<Texte> textes = texteRepository.findAll();
                System.out.println("-------TEXTE REPONSE-------" + textes.size());
                for (Texte t : textes) {
                    System.out.println(t.getId());
                    System.out.println(t.getLabel());
                }
        

        return texteList;

        // try {
        //     for (Materiel t : texteList) {
        //         texteRepository.save((Texte)t);
        //         // materielRepository.save(t);
        //         System.out.println(" possible de save les textes ");
        //     }
        //     return texteList;
        // } catch (Exception e) {
        //     throw new IllegalStateException("Impossible de save les textes.");
        // }
    }

    // private List<Repondre> LoadRepondre() {
    //     List<Repondre> repondreList = new ArrayList<Repondre>();
    //     return repondreList;
    // }

    private List<Reponse> LoadReponses() {

        LoadTextesReponses();
        List<Texte> textes = texteRepository.findAll();
        List<Reponse> reponses = new ArrayList<Reponse>();


        for (Texte t : textes) {
            System.out.println(t.getLabel());
        }

        Reponse reponse1 = new Reponse(textes.get(0), false);// bug vient de la car on récupère pas la liste de ceux qui sont save mais juste une liste d'objets
        // donc quand on essaye de save l'objet réponse avec un materiel qui au final n'est pas dans la base... bah ça plante hein L O G I Q U E.
        reponses.add(reponse1);
        Reponse reponse2 = new Reponse(textes.get(1), false);
        reponses.add(reponse2);
        Reponse reponse3 = new Reponse(textes.get(2), false);
        reponses.add(reponse3);
        Reponse reponse4 = new Reponse(textes.get(3), true);
        reponses.add(reponse4);

        try {
            System.out.println(" essaie de save les réponses 1");
            for (Reponse reponse : reponses) {
            System.out.println(" essaie de save les réponses 2");
                reponseRepository.save(reponse);
            System.out.println(" essaie de save les réponses ");
            }
            System.out.println(" essaie de save les réponses ");
            return reponses;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les réponses. "+e);
        }
    }

    private List<Etape> LoadQuestions() {
        List<Indice> indiceEtapes = new ArrayList<Indice>();
        List<Reponse> reponseList = new ArrayList<Reponse>();
        List<Etape> questions = new ArrayList<Etape>();
        indiceEtapes = LoadIndices();
        // reponseList = LoadReponses();
        Question question1 = new Question(1, "question1", "première question ?", reponseList, indiceEtapes);

        try {
            questions.add(question1);
            questionRepository.save(question1);
            return questions;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save les questions.   "+e);
        }
    }

    private List<Visite> LoadVisites() {
        Mode modeVisite = Mode.PRESENTIEL;
        Statut statutVisite = Statut.ENCOURS;
        List<Visite> visites = new ArrayList<Visite>();
        // List<Repondre> repondre = new ArrayList<Repondre>();
        // List<Indice> indiceVisite = new ArrayList<Indice>();
        // repondre = LoadRepondre();
        // indiceVisite = LoadIndices();
        Visite visite1 = new Visite("03/05/2022", "13:41", modeVisite, statutVisite, 4, 999, "difficile"/*, repondre,*/
                /*indiceVisite*/);
        try {
            visiteRepository.save(visite1);
            return visites;
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de save la visite.");
        }
    }

    private List<Defis> LoadDefis() {

        Type typeDefi = Type.CHALLENGE;
        Mode modeDefi = Mode.PRESENTIEL;
        List<Defis> defisList = new ArrayList<Defis>();
        List<Visite> visitesVoulues = new ArrayList<Visite>();
        // List<Etape> etapesVoulues = new ArrayList<Etape>();
        List<MotCle> motsClesDefis = new ArrayList<MotCle>();
        Prologue prologueDefis = new Prologue();
        Epilogue epilogueDefis = new Epilogue();
        List<Etape> questionsVoulues = new ArrayList<Etape>();
        Boolean actif = true;
        // List<Etape> etapesVoulues = new ArrayList<Etape>();

        visitesVoulues = LoadVisites();

        // etapesVoulues = questionsVoulues;

        motsClesDefis = LoadMotsCles();


        prologueDefis = LoadPrologue();

        epilogueDefis = LoadEpilogue();

        questionsVoulues = LoadQuestions();

        Defis defi = new Defis("bonjour", "premier défi !!", typeDefi, modeDefi, 5, 900, "aucuns.", "02/05/2022",
                "02/05/2022", visitesVoulues, prologueDefis, epilogueDefis, /* etapesVoulues */ questionsVoulues,
                motsClesDefis,actif);
        try {
            defisRepository.save(defi);
            defisList.add(defi);
            return defisList;
        } catch (Exception e) {
            throw new IllegalStateException("Liste des défis non sauvegardée.");
        }
    }

    private Ville LoadVille() {
        Ville grenoble = new Ville("grenoble");
        try {
            villeRepository.save(grenoble);
            return grenoble;
        } catch (Exception e) {
            throw new IllegalStateException("La ville n'a pas été sauvegardée.");
        }
    }

    private void LoadChamis() {
        Ville villeVoulue = LoadVille();
        List<Defis> defisVoulus = LoadDefis();
        List<Visite> visitesVoulues = LoadVisites();
        Boolean active = true;
        try {
            chamisRepository.save(
                    new Chamis("justin.goudon@outlook.fr", "goudonju", 21, "a", villeVoulue, defisVoulus,
                            visitesVoulues,active));
        } catch (Exception e) {
            throw new IllegalStateException("Impossible de créer le chamis");
        }
    }
}
