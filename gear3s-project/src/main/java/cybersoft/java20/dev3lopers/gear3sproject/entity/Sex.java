package cybersoft.java20.dev3lopers.gear3sproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sex")
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sex")
    private Set<Users> listUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getListUser() {
        return listUser;
    }

    public void setListUser(Set<Users> listUser) {
        this.listUser = listUser;
    }
}
