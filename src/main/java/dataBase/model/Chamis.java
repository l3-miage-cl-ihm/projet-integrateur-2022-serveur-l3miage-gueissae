package dataBase.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name = "getAllChamis", query = "SELECT i" + 
                                          " FROM Chamis i")

@Entity
public class Chamis {
    
    @Id
    private String login;

    @Column
    private Integer age;

    @OneToMany
    private List<Defis> defis;

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

    public List<Defis> getDefis() {
        return defis;
    }

    public void setDefis(List<Defis> defis) {
        this.defis = defis;
    }

    
}
