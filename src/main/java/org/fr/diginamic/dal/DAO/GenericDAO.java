package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.dal.Connexion;
import javax.persistence.EntityManager;

public abstract class  GenericDAO<T> {
    private EntityManager em = new Connexion().getManager();
    int i =0;
    public EntityManager getEm() {
        return em;
    }

    //    public GenericDAO() {
    //        try{
    //            Class param = (Class) this.getClass().getGenericSuperclass();
    ////            Class cla= (Class) param.getActualTypeArguments()[0];
    //            this.t = (T) param.newInstance();
    //        }catch (InstantiationException |IllegalAccessException e){
    //            throw new RuntimeException(e);
    //        }
    //    }
    public void save(T obj){
        System.out.println("--------------"+i+"--------------");

        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        ++i;
    }
    public void merge(T obj){
        System.out.println("--------------"+i+"--------------");

        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        ++i;
    }


}
