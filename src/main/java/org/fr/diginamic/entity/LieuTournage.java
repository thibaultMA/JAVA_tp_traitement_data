package org.fr.diginamic.entity;

import javax.persistence.*;

@Entity
public class LieuTournage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    String etatDept;
    String pays;
    String ville;

    public Long getId() {
        return id;
    }
}
