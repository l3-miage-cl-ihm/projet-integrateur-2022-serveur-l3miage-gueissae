package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import javax.persistence.Column;

@Entity
@Table(
     name = "LesReponses"
)
public class Reponse {
    
    // // // // // // // //
    //     COLONNES      //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="reponse_sequence")
    @SequenceGenerator(
        name="reponse_sequence",
        sequenceName="reponse_sequence",
        allocationSize = 1,
        initialValue=50
    )
    @Column
    (
        name= "identifiant",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false
    )
    private int identifiant;

    @Column
    (
        name= "bonneReponse",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = false
    )
    private boolean bonneReponse;

    @OneToOne(cascade = CascadeType.ALL)
    private Materiel materiel;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Reponse(){}

    public Reponse(Materiel materiel, boolean bonneReponse) {
        this.materiel = materiel;
        this.bonneReponse = bonneReponse;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getIdentifiant() {
        return identifiant;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public boolean isBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(boolean bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    
    
}
