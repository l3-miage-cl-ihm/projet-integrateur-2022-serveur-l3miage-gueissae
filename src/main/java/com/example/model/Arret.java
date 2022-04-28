package com.example.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(
        name="code",
        insertable = true,
        length = 30,
        nullable = false,
        unique=false,
        updatable = false
    )
    private String code;

    @Column(
        name="nom",
        insertable = true,
        length = 30,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String nom;

    @Column(
        name="ligne",
        insertable = true,
        length = 30,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String ligne;

    public Arret(String code, String nom, String ligne) {
        this.code = code;
        this.nom = nom;
        this.ligne = ligne;
    }

    public int getId() {
        return id;
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
}