package org.fr.diginamic.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connexion {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-JPA");
    public EntityManager getManager(){
        return emf.createEntityManager();
    }


}