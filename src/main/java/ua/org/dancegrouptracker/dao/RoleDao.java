package ua.org.dancegrouptracker.dao;

import ua.org.dancegrouptracker.model.Role;

/**
 * Created by SeVlad on 08.03.2017.
 */
public interface RoleDao extends GenericDao<Role, Long> {
    Role getRolesByName(String name);
}
