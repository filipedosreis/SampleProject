package br.com.filipe.model;

import javax.persistence.*;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "User.findByName",
                query = "SELECT u FROM User u where upper(u.name) like ?1") })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departament", nullable = false)
    private Departament departament;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament genero) {
        this.departament = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
