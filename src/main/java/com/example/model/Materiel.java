package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(
    name = "LesMateriels"
)
@Inheritance(strategy = InheritanceType.JOINED)
public class Materiel{

    // // // // // // // //
    //      COLONNE      //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
        name="identifiant",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int identifiant;

    @Column(
        name="numero",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int numero;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Materiel() {}

    public Materiel(int numero) {
        this.numero = numero;
    }

    
    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getId() {
        return identifiant;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

} 