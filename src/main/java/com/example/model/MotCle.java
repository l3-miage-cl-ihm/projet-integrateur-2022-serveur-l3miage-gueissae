package com.example.model;


import javax.persistence.*;

@Entity
@Table(
    name = "LesMotsCles"
)
public class MotCle {


    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY,
    generator="motCle_sequence")
    @SequenceGenerator(
        name="motCle_sequence",
        sequenceName="motCle_sequence",
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
    private int identifiant;

    @Column(
        name="mot",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = true
    )
    private String mot;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public MotCle() {}

    public MotCle(String mot) {
        this.mot = mot;
    }

    
    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getidentifiant() {
        return identifiant;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }





}
