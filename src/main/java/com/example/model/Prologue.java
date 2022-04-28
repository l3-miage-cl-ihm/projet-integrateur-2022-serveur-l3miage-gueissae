package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (
    name = "LesPrologues"
)
public class Prologue {
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

    public Prologue(){}

    public int getId() {
        return id;
    }
}
