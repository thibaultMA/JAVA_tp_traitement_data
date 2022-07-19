package org.fr.diginamic.dal.DAO;

import org.fr.diginamic.entity.Role;

public class RoleDAO extends GenericDAO<Role> {
    public Role find(int id){
        return getEm().find(Role.class,id);
    }
}
