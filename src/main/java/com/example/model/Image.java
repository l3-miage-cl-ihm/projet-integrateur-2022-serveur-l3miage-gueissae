package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesImages"
)
public class Image extends Materiel{

    @Column(
        name="label",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String label;
    
    @Column(
        name="chemin",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String chemin;

    public Image(int numero, String label, String chemin) {
        super(numero);
        this.label = label;
        this.chemin = chemin;
    }

    public Image() {
        
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

}