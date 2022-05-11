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

    // // // // // // // //
    //      COLONNES     //
    // // // // // // // //

    @Id
    @Column(
        name="email",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = false
    )
    private String email;
    
    @Column(
        name="login",
        insertable = true,
        nullable = false,
        unique=true,
        updatable = true
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
        nullable = true,
        unique=false,
        updatable = true
    )
    private String description;

    @Column(
        name="active",
        insertable = true,
        nullable = true,
        unique=false,
        updatable = true
    )
    private Boolean active;

    @ManyToOne
    private Ville ville;

    @OneToMany
    private List<Defis> defis;

    @OneToMany
    private List<Visite> visites;

    // // // // // // // // 
    //   CONSTRUCTEURS   //
    // // // // // // // //

    public Chamis() {}

    public Chamis(Chamis chami){
        this.email = chami.getEmail();
        this.login = chami.getLogin();
        this.age = chami.getAge();
        this.description = chami.getDescription();
        this.ville = chami.getVille();
        this.defis = chami.getDefis();
        this.active = chami.getActive();
    }

    public Chamis(String email, String login, Integer age, String description, Ville ville, List<Defis> defis,
            List<Visite> visites, Boolean active) {
        this.email = email;
        this.login = login;
        this.age = age;
        this.description = description;
        this.ville = ville;
        this.defis = defis;
        this.visites = visites;
        this.active = active;
    }


    // // // // // // // // 
    //     GET & SET     //
    // // // // // // // //

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Defis> getDefis() {
        return defis;
    }

    public void setDefis(List<Defis> defis) {
        this.defis = defis;
    }

    public void addDefi(Defis defi) {
        List<Defis> lesDefis = this.getDefis();
        lesDefis.add(defi);
        this.setDefis(lesDefis);
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

}
