package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(
     name = "LesIndices"
)

public class Indice{

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
    generator="indice_sequence")
    @SequenceGenerator(
        name="indice_sequence",
        sequenceName="defis_sequence",
        allocationSize = 1,
        initialValue=50
    )
    @Column(
        name="identifiant",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private Integer identifiant;


    @Column(
        name="label",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String label;

    @Column(
        name="description",
        insertable = true,
        nullable = true,
        unique=false,
        updatable = true
    )
    private String description;

    @Column(
        name="points",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int points;

 

    
    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Indice() {}

    public Indice(String label, String description, int points) {
        this.label = label;
        this.description = description;
        this.points = points;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public Integer getIdentifiant() {
        return identifiant;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

 

    

   

    

    
    
}
