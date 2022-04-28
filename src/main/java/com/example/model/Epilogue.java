package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(
     name = "LesEpilogues"
)
public class Epilogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    (
        name= "id",
        insertable = true,
        nullable = false,
        unique = true,
        updatable = false

    )
    private int id;

    public Epilogue(){}

    public int getId() {
        return id;
    }
    
}


