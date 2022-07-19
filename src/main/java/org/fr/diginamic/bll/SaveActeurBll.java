package org.fr.diginamic.bll;

import org.fr.diginamic.dal.DAO.*;
import org.fr.diginamic.entity.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SaveActeurBll {
    static String URL = "C:\\Users\\moi\\Desktop\\code\\cours\\diginamics\\java\\GrosProjet\\JAVA_TP_Traitement-Data\\src\\main\\resources\\films.json";

    private static FilmDAO filmDAO = new FilmDAO();
    private static ActeurDAO acteurDAO = new ActeurDAO();

    private static GenrDAO GenrDao = new GenrDAO();
    private static PaysDAO paysDAO = new PaysDAO();
    private static RoleDAO roleDAO = new RoleDAO();
    private static RealisateurDAO realsateurDao = new RealisateurDAO();

    public void saveBDD(){
        {

            JSONParser parser = new JSONParser();
            List<Acteur> acteurList = new ArrayList<>();
            try {

                JSONArray results = (JSONArray) parser.parse(new FileReader(URL));
//            JSONObject person = (JSONObject) results.get(0);
                for (Object persone : results) {
                    JSONObject person = (JSONObject) persone;

                    Acteur acteur = acteurDAO.findId(person.get("id").toString());
                    if (acteur ==null){
                        acteur = new Acteur();
                        acteur.setId(person.get("id").toString());
                        acteurDAO.save(acteur);
                    }
                    // gere id {debut}
                    // gere id {fin}

                    // gere identite {debut}
                    acteur.setIdentite(person.get("identite").toString());
                    // gere identite {fin}

                    // gere la naissance {debut}
                    JSONObject naissanceJsonObjet = (JSONObject) person.get("naissance");
                    Naissance naissance = new Naissance(naissanceJsonObjet.get("lieuNaissance").toString(),naissanceJsonObjet.get("dateNaissance").toString());
                    acteur.setNaissance(naissance);
                    // gere la naissance {fin}

                    // gere url {debut}
                    acteur.setUrl(person.get("url").toString());
                    // gere url {fin}

                    // gere rôle {debut}
                    JSONArray roleJsonOArray = (JSONArray) person.get("roles");
                    Set<Role> roleList = new LinkedHashSet<>();
                    System.out.println("1\t"+acteur);

                    for (Object roleJson : roleJsonOArray) {
                        JSONObject roleJSONObject = (JSONObject) roleJson;
                        Integer idRole = (Integer) roleJSONObject.get("id");
                        Role role = null;
                        if (idRole != null){
                            role = roleDAO.find(idRole);
                        }
                        if (role == null){
                            role = new Role();
                            roleDAO.save(role);
                        }
                        //gere characterName
                        role.setCharacterName(roleJSONObject.get("characterName").toString());
                        //gere film
                        JSONObject filmObject = (JSONObject) roleJSONObject.get("film");
                        Film film = filmDAO.find(filmObject.get("id").toString());
                        if (film == null) {
                            film = new Film();
                        }
                        film.setId(filmObject.get("id").toString());
                        film.setAnneeSortie(filmObject.get("anneeSortie").toString());
                        film.setLangue((String) filmObject.get("langue"));
                        film.setNom(filmObject.get("nom").toString());
                        film.setPlot((String) filmObject.get("plot"));
                        film.setUrl(filmObject.get("url").toString());
                        filmDAO.save(film);
                        // gere acteur du film {debut}
                        JSONArray filmActeurs = (JSONArray) filmObject.get("acteurs");
                        List<Acteur> acteurListfilm = new ArrayList<>();
                        for (Object acteurs : filmActeurs) {
                            JSONObject filmActeurJSONObject = (JSONObject) acteurs;
                            String idActeur = (String) filmActeurJSONObject.get("id");
                            /*trouve dans la db si id existe et s'il existe add le sinon cree le */
                            Acteur filmActeur = acteurDAO.findId(idActeur);
                            if (filmActeur == null) {
                                filmActeur = new Acteur();
                                filmActeur.setId(idActeur);
                                acteurDAO.save(filmActeur);
                            }
                            filmActeur.setIdentite((String) filmActeurJSONObject.get("identite"));
                            JSONObject acteurFilmNaissanceJsonObjet = (JSONObject) person.get("naissance");
                            Naissance acteurFilmNaissance = new Naissance(acteurFilmNaissanceJsonObjet.get("lieuNaissance").toString(), acteurFilmNaissanceJsonObjet.get("dateNaissance").toString());
                            filmActeur.setNaissance(acteurFilmNaissance);
                            filmActeur.setUrl((String) filmActeurJSONObject.get("url"));

                            acteurListfilm.add(filmActeur);
                            acteurDAO.merge(filmActeur);
                        }
                        film.setActeurs(acteurListfilm);
                        // gere acteur du film {fin}

                        // gere casting du film {debut}
                        JSONArray casting = (JSONArray) filmObject.get("castingPrincipal");
                        List<Acteur> castingFilm = new ArrayList<>();
                        for (Object acteurs : casting) {
                            JSONObject filmActeurJSONObject = (JSONObject) acteurs;
                            String idActeur = (String) filmActeurJSONObject.get("id");
                            /*trouve dans la db si id existe et s'il existe add le sinon cree le */
                            Acteur filmActeur = (Acteur) acteurDAO.findId(idActeur);
                            if (filmActeur == null) {
                                filmActeur = new Acteur();
                                acteurDAO.save(filmActeur);
                            }
                            filmActeur.setId(idActeur);
                            filmActeur.setIdentite((String) filmActeurJSONObject.get("identite"));
                            JSONObject acteurFilmNaissanceJsonObjet = (JSONObject) person.get("naissance");
                            Naissance acteurFilmNaissance = new Naissance(acteurFilmNaissanceJsonObjet.get("lieuNaissance").toString(), acteurFilmNaissanceJsonObjet.get("dateNaissance").toString());
                            filmActeur.setNaissance(acteurFilmNaissance);
                            filmActeur.setUrl((String) filmActeurJSONObject.get("url"));
                            castingFilm.add(filmActeur);
                            acteurDAO.merge(filmActeur);

                        }
                        film.setCastingPrincipal(castingFilm);
                        // gere casting du film {fin}

                        // gere genres {debut}
                        JSONArray genrArray = (JSONArray) filmObject.get("genres");
                        List<Genre> genreList = new ArrayList<>();
                        for (Object genres : genrArray) {
                            Genre genre = GenrDao.find((String) genres);
                            if (genre == null){
                                genre = new Genre((String) genres);
                                GenrDao.save(genre);
                            }
                            GenrDao.merge(genre);
                            genreList.add(genre);
                        }
                        film.setGenres(genreList);
                        role.setFilm(film);

                        // gere Pays {debut}
                        JSONObject paysJsonObject = (JSONObject) filmObject.get("pays");
                        Pays pays = null;
                        if (paysJsonObject != null){
                            Pays currentpays = paysDAO.findByUrl((String) paysJsonObject.get("id"));
                            if (currentpays == null){
                                pays = new Pays(paysJsonObject.get("nom").toString(), paysJsonObject.get("url").toString());
                                paysDAO.save(pays);
                            }
                            pays = currentpays;
                        }
                        film.setPays(pays);

                        // gere Pays {fin}

                        // gere Realisateur{debut}
                        JSONArray realisateurs = (JSONArray) filmObject.get("realisateurs");
                        List<Realisateur> realisateurList = new ArrayList<>();
                        for (Object realisateur : realisateurs) {
                            JSONObject realisateurObject = (JSONObject) realisateur;
                            Realisateur realisateur1 = realsateurDao.find((String) realisateurObject.get("url"));
                            System.out.println(realisateurObject.get("url"));
                            if (realisateur1 == null) {
                                realisateur1 = new Realisateur();
                                realisateur1.setUrl((String) realisateurObject.get("url"));
                                realisateur1.setIdentite((String) realisateurObject.get("identite"));
                                realsateurDao.save(realisateur1);
                            }

                            realisateurList.add(realisateur1);
                        }
                        film.setRealisateurs(realisateurList);
                        filmDAO.merge(film);
                        // gere Realisateur{fin}

                        role.setFilm(film);
                        roleList.add(role);
                        roleDAO.merge(role);
                    }

                    acteur.setRoles(roleList);
                    acteurDAO.merge(acteur);
                }

            } catch (ParseException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
