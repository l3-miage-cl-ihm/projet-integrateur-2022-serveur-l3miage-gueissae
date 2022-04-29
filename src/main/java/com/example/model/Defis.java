package com.example.model;

import com.example.enumeration.Mode;
import com.example.enumeration.Type;

import java.util.List;

import javax.persistence.*;

@NamedQuery(name = "getAllDefis", query = "SELECT d" + 
                                          " FROM Defis d")

@Entity
@Table(
    name = "LesDefis"
)
public class Defis{

    // // // // // // // //
    //      COLONNE      //
    // // // // // // // //

    private static Integer identifiant = 1;

    @Id 
    @Column
    (
        name= "id",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false

    )
    private String id;

    @Column
    (
        name= "titre",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true

    )
    private String titre;

    @Column
    (
        name= "description",
        insertable = true,
        nullable = true,
        unique = false,
        updatable = true

    )
    private String description;

    @Column(
        name= "type",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private Type type;

    @Column(
        name= "distanciel",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private Mode distanciel;

    @Column(
        name= "point",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private int point;

    @Column(
        name= "duree",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private int duree;

    @Column(
        name= "commentaire",
        insertable = true,
        nullable = true,
        unique = false,
        updatable = true
    )
    private String commentaire;

    @Column(
        name= "dateDeCreation",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private String dateDeCreation;

    @Column(
        name= "dateDeModification",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private String dateDeModification;

    @OneToMany
    private List<Visite> visites;

    @OneToOne
    private Prologue prologue;

    @OneToOne
    private Epilogue epilogue;

    @OneToMany
    private List<Etape> etapes;

    @ManyToMany
    private List<MotCle> motsCles;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Defis(){
        this.setId();   
    }

    public Defis(String titre, String description, Type type, Mode distanciel, int point, int duree, String commentaire,
            String dateDeCreation, String dateDeModification, List<Visite> visites, Prologue prologue,
            Epilogue epilogue, List<Etape> etapes, List<MotCle> motsCles) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.distanciel = distanciel;
        this.point = point;
        this.duree = duree;
        this.commentaire = commentaire;
        this.dateDeCreation = dateDeCreation;
        this.dateDeModification = dateDeModification;
        this.visites = visites;
        this.prologue = prologue;
        this.epilogue = epilogue;
        this.etapes = etapes;
        this.motsCles = motsCles;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = "" + getIdentifiant();
        setIdentifiant(identifiant + 1);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Mode getDistanciel() {
        return distanciel;
    }

    public void setDistanciel(Mode distanciel) {
        this.distanciel = distanciel;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getDateDeModification() {
        return dateDeModification;
    }

    public void setDateDeModification(String dateDeModification) {
        this.dateDeModification = dateDeModification;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    public Prologue getPrologue() {
        return prologue;
    }

    public void setPrologue(Prologue prologue) {
        this.prologue = prologue;
    }

    public Epilogue getEpilogue() {
        return epilogue;
    }

    public void setEpilogue(Epilogue epilogue) {
        this.epilogue = epilogue;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    private static Integer getIdentifiant() {
        return identifiant;
    }

    private static void setIdentifiant(Integer identifiant) {
        Defis.identifiant = identifiant;
    }

    public List<MotCle> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotCle> motsCles) {
        this.motsCles = motsCles;
    }    

}