package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Acteur;
import org.fr.diginamic.entity.Film;

import javax.persistence.NoResultException;

public class ActeurDAO extends GenericDAO<Acteur> {
    public Acteur findId(String id){
        return this.getEm().find(Acteur.class,id);
    }
    public Acteur findByName(String identite)  {
        Acteur a=null;
        try{
            a = (Acteur) getEm().createQuery("Select r from Acteur r where r.identite IN :identite")
                    .setParameter("identite", identite).getSingleResult();
        }
        catch (NoResultException e){

        }
        System.out.println(a);
        if(a == null){
            return a;
        }
        return a ;
    }
}
