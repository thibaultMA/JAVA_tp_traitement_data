package org.fr.diginamic.dal.DAO;

import com.fasterxml.classmate.GenericType;
import org.fr.diginamic.entity.Acteur;
import org.fr.diginamic.entity.Film;
import org.fr.diginamic.entity.Realisateur;

import javax.persistence.NoResultException;

public class FilmDAO extends GenericDAO<Film> {
    public Film find(String id){
        return getEm().find(Film.class,id);
    }
    public Film findByName(String realUrl)  {
        Film a=null;
        try{
            a = (Film) getEm().createQuery("Select r from Film r where r.url IN :url")
                    .setParameter("url", realUrl).getSingleResult();
        }
        catch (NoResultException e){

        }
        if(a == null){
            return a;
        }
        return a ;
    }

}
