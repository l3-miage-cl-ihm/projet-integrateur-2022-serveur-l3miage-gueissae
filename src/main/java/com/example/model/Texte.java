package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(
    name = "LesTextes"
)
@PrimaryKeyJoinColumn(name = "texteIdentifiant")
public class Texte extends Materiel {


    // // // // // // // //
    //      COLONNE      //
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
    //    CONSTRUCTEUR   //
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
