package org.fr.diginamic.entity;

import javax.persistence.*;

@Embeddable
public class Naissance {
    private String dateNaissance;
    private String lieuNaissance;

    public Naissance(String dateNaissance, String lieuNaissance) {
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }public Naissance() {

    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }
    @Override
    public String toString() {
        return "Naissance{" +
                "dateNaissance='" + dateNaissance + '\'' +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                '}';
    }
}
