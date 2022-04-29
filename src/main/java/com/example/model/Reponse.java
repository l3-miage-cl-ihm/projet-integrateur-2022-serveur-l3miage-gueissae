package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table(
     name = "LesReponses"
)
public class Reponse {
    
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

    public Reponse(){

    }

    

    public Reponse(Materiel materiel) {
        this.materiel = materiel;
    }



    public int getId() {
        return id;
    }
    
    
}
