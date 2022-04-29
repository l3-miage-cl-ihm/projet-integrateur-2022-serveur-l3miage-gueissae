package com.example.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(
    name = "LesMotsCles"
)
public class MotCle {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(
        name="id",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private int id;

    @Column(
        name="mot",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = true
    )
    private String mot;

    @ManyToMany
    private List<Defis> defis;

    

    public MotCle(String mot, List<Defis> defis) {
        this.mot = mot;
        this.defis = defis;
    }

    public MotCle() {
    }

    public int getId() {
        return id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }   
}
