package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Genre;
import org.fr.diginamic.entity.Realisateur;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class GenrDAO extends GenericDAO<Genre> {
    public Genre find(String nom) {
        Genre a=null;
        Query query=  getEm().createQuery("Select r from Genre r where r.nom IN :nom")
                .setParameter("nom", nom);
        try{
            a = (Genre)query.getSingleResult();
        }
        catch (NoResultException e){

        }
        if(a == null){
            return a;
        }
        return a ;
    }

}
