package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name = "getAllChamis", query = "SELECT i" + 
                                          " FROM Chamis i")

@Entity
@Table(
    name = "LesChamis"
)
public class Chamis {

    @Id
    @Column(
        name="email",
        insertable = true,
        length = 30,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String email;
    
    @Column(
        name="login",
        insertable = true,
        length = 30,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String login;

    @Column(
        name="age",
        insertable = true,
        nullable = false,
        unique=false,
        updatable = true
    )
    private Integer age;

    @Column(
        name="description",
        insertable = true,
        length = 500,
        nullable = true,
        // table = "LesChamis",
        unique=false,
        updatable = true
    )
    private String description;

    @ManyToOne
    private Ville ville;

    @OneToMany
    @Column(
        name="defis",
        insertable = true,
        length = 100,
        nullable = true,
        unique=false,
        updatable = true
    )
    private List<Defis> defis;

    public Chamis() {
	}

    public Chamis(String email, String login, Integer age, String description, Ville ville, List<Defis> defis) {
        this.email = email;
        this.login = login;
        this.age = age;
        this.description = description;
        this.ville = ville;
        this.defis = defis;
    }

    public Chamis(Chamis chami){
        this.email = chami.getEmail();
        this.login = chami.getLogin();
        this.age = chami.getAge();
        this.description = chami.getDescription();
        this.ville = chami.getVille();
        this.defis = chami.getDefis();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Defis> getDefis() {
        return defis;
    }

    public void setDefis(List<Defis> defis) {
        this.defis = defis;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
