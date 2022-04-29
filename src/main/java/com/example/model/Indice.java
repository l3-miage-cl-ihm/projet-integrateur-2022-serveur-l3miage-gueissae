package com.example.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table(
     name = "LesIndices"
)

public class Indice extends Etape {


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



    public Indice(int numero, String label, String description, int points, List<Visite> visites) {
        super(numero);
        this.label = label;
        this.description = description;
        this.points = points;
        this.visites = visites;
    }

    public Indice() {
        
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
