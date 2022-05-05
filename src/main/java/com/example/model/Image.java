package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesImages"
)
@PrimaryKeyJoinColumn(name = "imageIdentifiant")
public class Image extends Materiel{

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //
    
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


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Image() {}

    public Image(int numero, String label, String chemin) {
        super(numero);
        this.label = label;
        this.chemin = chemin;
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

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

}