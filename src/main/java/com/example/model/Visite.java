package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.enumeration.Mode;
import com.example.enumeration.Statut;

@Entity
@Table (
    name = "LesVisites"
)

public class Visite {

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
        name="identifiant",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int identifiant;
    
    @Column(
        name="date",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = false
    )
    private String date;

    @Column(
        name="heure",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = false
    )
    private String heure;

    @Column(
        name="mode",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private Mode mode;

    @Column(
        name="statut",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private Statut statut;

    @Column(
        name="score",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int score;

    @Column(
        name="temps",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int temps;

    @Column(
        name="commentaire",
        insertable = true,
        nullable = true,
        unique=false,
        updatable = true
    )
    private String commentaire;

    @OneToMany
    private List<Repondre> repondres;
    
    @ManyToMany
    private List<Indice> indices;

    
    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //
    
    public Visite(){}

    public Visite(String date, String heure, Mode mode, Statut statut, int score, int temps, String commentaire,
            List<Repondre> repondres, List<Indice> indices) {
        this.date = date;
        this.heure = heure;
        this.mode = mode;
        this.statut = statut;
        this.score = score;
        this.temps = temps;
        this.commentaire = commentaire;
        this.repondres = repondres;
        this.indices = indices;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getIdentifiant() {
        return identifiant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<Repondre> getRepondres() {
        return repondres;
    }

    public void setRepondres(List<Repondre> repondres) {
        this.repondres = repondres;
    }

    public List<Indice> getIndices() {
        return indices;
    }

    public void setIndices(List<Indice> indices) {
        this.indices = indices;
    }

    

    

}
