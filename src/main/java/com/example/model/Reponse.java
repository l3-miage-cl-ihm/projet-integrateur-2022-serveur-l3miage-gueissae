package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    (
        name= "identifiant",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false
    )
    private int identifiant;

    @OneToOne
    private Materiel materiel;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Reponse(){}

    public Reponse(Materiel materiel) {
        this.materiel = materiel;
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
    
}
