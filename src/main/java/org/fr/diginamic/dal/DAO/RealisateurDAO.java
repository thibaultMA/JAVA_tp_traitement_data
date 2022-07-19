package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Realisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class RealisateurDAO extends GenericDAO<Realisateur> {
private EntityManager em = super.getEm();
    public Realisateur find(String realUrl)  {
        Realisateur a=null;
        try{
            a = (Realisateur) em.createQuery("Select r from Realisateur r where r.url IN :url")
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
