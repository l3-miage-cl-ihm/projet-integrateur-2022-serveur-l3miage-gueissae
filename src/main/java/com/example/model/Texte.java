package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesTextes"
)
public class Texte extends Materiel {


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


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Texte() {}

    public Texte(int numero, String label) {
        super(numero);
        this.label = label;
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
        
}
