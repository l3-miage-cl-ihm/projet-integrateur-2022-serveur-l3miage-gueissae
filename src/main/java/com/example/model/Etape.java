package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@Entity
@Table (
    name = "LesEtapes"
)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @MappedSuperclass
// @DiscriminatorColumn(name="type_etape")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
{
    @Type(value = Question.class, name = "Question"),
    @Type(value = Information.class, name = "Information")
})
public abstract class Etape {

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
        name ="identifiant",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false
    )
    private int identifiant;

    @Column(
        name ="numero",
        insertable = true,
        nullable = false,
        unique = false,
        updatable = true
    )
    private int numero;


    // // // // // // // // 
    //    CONSTRUCTEURS  //
    // // // // // // // //

    public Etape(){}

    public Etape(int numero){
        this.numero = numero;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getIdentifiant() {
        return identifiant;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}
