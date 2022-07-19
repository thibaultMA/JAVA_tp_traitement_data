package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Pays;
import org.fr.diginamic.entity.Realisateur;

import javax.persistence.NoResultException;

public class PaysDAO extends GenericDAO<Pays> {
    public Pays findId(int id){
        return getEm().find(Pays.class,id);
    }
    public Pays findByUrl(String realUrl)  {
        Pays a=null;
        try{
            a = (Pays) getEm().createQuery("Select r from Pays r where r.url IN :url")
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
