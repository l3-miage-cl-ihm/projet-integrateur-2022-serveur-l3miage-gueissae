package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table(
     name = "LesEpilogues"
)
public class Epilogue {

    // // // // // // // //
    //      COLONNE      //
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

    @OneToMany
    private List<Materiel> materiels;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Epilogue(){}

    public Epilogue(List<Materiel> materiels) {
        this.materiels = materiels;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getIdentifiant() {
        return identifiant;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    
    
}


