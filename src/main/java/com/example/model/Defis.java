package com.example.model;

import com.example.enumeration.Mode;
import com.example.enumeration.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    //      COLONNES     //
    // // // // // // // //

    private static Integer indice = 1;

    @Id 
    @Column
    (
        name= "identifiant",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false

    )
    @GeneratedValue(strategy = GenerationType.AUTO,
    generator="defis_sequence")
    @SequenceGenerator(
        name="defis_sequence",
        sequenceName="defis_sequence",
        allocationSize = 1,
        initialValue=50
    )
    private Integer identifiant;

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
        name= "mode",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private Mode mode;

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

    @Column(
        name= "actif",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private Boolean actif;

    @OneToMany
    private List<Visite> visites;

    @OneToMany
    private List<Materiel> prologue;

    @OneToMany
    private List<Materiel> epilogue;

    @OneToMany
    @OrderBy("numero")
    private List<Etape> etapes;

    @ManyToMany
    private List<MotCle> motsCles;


    @JsonIgnoreProperties("defis")
    @ManyToOne(fetch = FetchType.LAZY)
    private Arret arret;

    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Defis(){
        this.setIdentifiant();   
    }

    public Defis(String titre, String description, Type type, Mode mode, int point, int duree, String commentaire,
            String dateDeCreation, String dateDeModification, List<Visite> visites, List<Materiel> prologue,
            List<Materiel> epilogue, List<Etape> etapes, List<MotCle> motsCles, Boolean actif) {
        this.setIdentifiant();
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.mode = mode;
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
        this.actif = actif;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public Integer getIdentifiant() {
        return identifiant;
    }

    private void setIdentifiant() {
        // this.identifiant = "" + getindice();
        // setindice(indice + 1);
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

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
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

    public Boolean getActif(){
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    public List<Materiel> getPrologue() {
        return prologue;
    }

    public void setPrologue(List<Materiel> prologue) {
        this.prologue = prologue;
    }

    public List<Materiel> getEpilogue() {
        return epilogue;
    }

    public void setEpilogue(List<Materiel> epilogue) {
        this.epilogue = epilogue;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    private static Integer getindice() {
        return indice;
    }

    private static void setindice(Integer indice) {
        Defis.indice = indice;
    }

    public List<MotCle> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotCle> motsCles) {
        this.motsCles = motsCles;
    }    

    public void addMotCle(MotCle  motcle)  {
        this.motsCles.add(motcle);
    }
    public void  suppressMotCle(MotCle motcle){
        this.motsCles.remove(motcle);
    }


    public Arret getArret() {
        return arret;
    }

    public void setArret(Arret arret) {
        this.arret = arret;
    }
}