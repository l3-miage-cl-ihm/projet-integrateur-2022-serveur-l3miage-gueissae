package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (
    name = "LesPrologues"
)
public class Prologue {

    // // // // // // // //
    //      COLONNE      //
    // // // // // // // //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
        name="id",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int id;

    @OneToMany
    private List<Materiel> materiels;


    // // // // // // // // 
    //    CONSTRUCTEUR   //
    // // // // // // // //

    public Prologue(){}

    public Prologue(List<Materiel> materiels) {
        this.materiels = materiels;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getId() {
        return id;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

}
