package org.fr.diginamic.dal.DAO;

import com.fasterxml.classmate.GenericType;
import org.fr.diginamic.entity.Acteur;
import org.fr.diginamic.entity.Film;

public class FilmDAO extends GenericDAO<Film> {
public Film find(String id){
    return this.getEm().find(Film.class,id);
}
}
