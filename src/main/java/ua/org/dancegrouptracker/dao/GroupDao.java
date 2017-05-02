package ua.org.dancegrouptracker.dao;

import ua.org.dancegrouptracker.model.Group;

/**
 * Created by SeVlad on 02.05.2017.
 */
public interface GroupDao extends GenericDao<Group,Long> {
    Group getGroupByName(String name);
}
