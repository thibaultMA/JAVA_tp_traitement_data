package org.fr.diginamic.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Acteur {
    @Id
    @Column(unique = true)
    private String id;
    private String identite;
    @Embedded
    private Naissance naissance;

    private String url;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Acteur_roles",
            joinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Set<Role> roles = new LinkedHashSet<>();


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public Naissance getNaissance() {
        return naissance;
    }

    public void setNaissance(Naissance naissance) {this.naissance = naissance;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "identite='" + identite + '\'' +
                ", naissance=" + naissance +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", roles=" + roles +
                '}';
    }
}
