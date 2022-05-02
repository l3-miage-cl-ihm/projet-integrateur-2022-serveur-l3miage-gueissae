package com.example.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

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
    @Column(
        name="identifiant",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String identifiant;


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

    @OneToMany
    private List<Visite> visites;

    
    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Indice() {}

    public Indice(String label, String description, int points, List<Visite> visites) {
        this.label = label;
        this.description = description;
        this.points = points;
        this.visites = visites;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

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

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    

   

    

    
    
}
