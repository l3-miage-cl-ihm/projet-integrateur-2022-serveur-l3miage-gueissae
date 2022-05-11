package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@Entity
@Table(
    name = "LesMateriels"
)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
{
    @Type(value = Image.class, name = "Image"),
    @Type(value = Video.class, name = "Video"),
    @Type(value = Texte.class, name = "Texte")
})
public class Materiel{

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator ="materiel_sequence")
    @SequenceGenerator(
        name="materiel_sequence",
        sequenceName="materiel_sequence",
        allocationSize = 1,
        initialValue=50
    )
    private Integer identifiant;

    @Column(
        name="numero",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int numero;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
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