package br.com.filipe.model;

import javax.persistence.*;

/**
 * Created by filipedosreis@gmail.com on 10/02/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departament", nullable = false)
    private Departament genero;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(unique = true, length = 100, nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departament getGenero() {
        return genero;
    }

    public void setGenero(Departament genero) {
        this.genero = genero;
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
