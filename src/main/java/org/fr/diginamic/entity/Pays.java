package org.fr.diginamic.entity;

import javax.persistence.*;

@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String nom;
    private String url;

    public Long getId() {
        return id;
    }

    public Pays(String nom, String url) {
        this.nom = nom;
        this.url = url;
    }

    public Pays() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
