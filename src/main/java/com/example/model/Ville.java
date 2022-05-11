package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesVilles"
)
public class Ville {

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name="identifiant",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int identifiant;

    @Column(
        name="ville",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = false
    )
    private String ville;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Ville(){}

    public Ville(String ville) {
        this.setVille(ville);
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getIdentifiant() {
        return identifiant;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
