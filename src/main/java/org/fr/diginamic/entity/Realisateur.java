package org.fr.diginamic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "realisateur")
public class Realisateur {
    private String identite;
    @Id
    private String url;

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Realisateur{" +
                "identite='" + identite + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
