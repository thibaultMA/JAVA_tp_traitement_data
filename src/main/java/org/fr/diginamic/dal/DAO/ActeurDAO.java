package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Acteur;

public class ActeurDAO extends GenericDAO<Acteur> {
    public Acteur findId(String id){
        return this.getEm().find(Acteur.class,id);
    }
}
