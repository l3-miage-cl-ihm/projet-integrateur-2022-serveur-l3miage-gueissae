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
    //      COLONNE      //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    (
        name= "id",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false
    )
    private int id;

    @OneToOne
    private Materiel materiel;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Reponse(){}

    public Reponse(Materiel materiel) {
        this.materiel = materiel;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getId() {
        return id;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
    
}
