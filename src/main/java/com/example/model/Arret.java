package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (
    name = "LesArrets",
    uniqueConstraints = {
        @UniqueConstraint(name="ligne_code_nom", columnNames = {"nom", "ligne", "code"})
    }
)
public class Arret {

    // // // // // // // //
    //      COLONNES     //
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
        name="code",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String code;

    @Column(
        name="nom",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String nom;

    @Column(
        name="ligne",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String ligne;
    @Column(
        name="lon",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String lon;

    @Column(
        name="lat",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private String lat;


    @OneToMany
    private List<Defis> defis;


    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Arret() {}

    public Arret(String code, String nom, String ligne,String longitude,String latitude, List<Defis> defis) {
        this.code = code;
        this.nom = nom;
        this.ligne = ligne;
        this.defis = defis;
        // this.longitude= longitude;
        // this.latitude= latitude;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public int getId() {
        return identifiant;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public List<Defis> getDefis() {
        return defis;
    }

    public void setDefis(List<Defis> defis) {
        this.defis = defis;
    }
    public String getLongitude() {
        return this.lon; 
    }
    public String getLatitude() {
        return this.lat; 
    }
    public void setLongitude(String longitude) {
        this.lon = longitude;
    }

    public void setLatitude(String latitude) {
        this.lat = latitude;
    }
}