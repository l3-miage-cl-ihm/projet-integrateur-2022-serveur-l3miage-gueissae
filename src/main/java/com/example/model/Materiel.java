package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(
    name = "LesMateriels"
)
public abstract class Materiel{

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
        name="numero",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private int numero;

    public Materiel(int numero) {
        this.numero = numero;
    }

    public Materiel() {

    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    


} 