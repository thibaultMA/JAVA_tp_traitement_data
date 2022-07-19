package org.fr.diginamic.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Film {

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;
    private String nom;
    private String url;
    private String plot;
    @Id

    private String id;
    private String langue;
    @ManyToOne
    @JoinColumn(name = "lieu_tournage_id")
    private LieuTournage lieuTournage;
    @ManyToMany
    @JoinTable(name = "film_realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private List<Realisateur> realisateurs = new ArrayList<Realisateur>();
    @ManyToMany
    @JoinTable(name = "casting_Film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id"))
    private List<Acteur> castingPrincipal = new ArrayList<Acteur>();
    private String anneeSortie;
    @ManyToMany
    @JoinTable(name = "genre_Film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id"))
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Acteur_Film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id"))
    private List<Acteur> acteurs = new ArrayList<Acteur>();

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LieuTournage getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(LieuTournage lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<Acteur> getCastingPrincipal() {
        return castingPrincipal;
    }

    public void setCastingPrincipal(List<Acteur> castingPrincipal) {
        this.castingPrincipal = castingPrincipal;
    }

    public String getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", anneeSortie='" + anneeSortie + '\'' +
                ", langue='" + langue + '\'' +
                ", nom='" + nom + '\'' +
                ", url='" + url + '\'' +
                ", plot='" + plot + '\'' +
                "pays=" + pays +
                ", lieuTournage=" + lieuTournage +
                ", realisateurs=" + realisateurs +
                ", castingPrincipal=" + castingPrincipal +
                ", genres=" + genres +
                ", acteurs=" + acteurs +
                '}';
    }
}
