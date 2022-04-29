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
    //      COLONNE      //
    // // // // // // // //
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
        name="id",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int id;

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

    public int getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
