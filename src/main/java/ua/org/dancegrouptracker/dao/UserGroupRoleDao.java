package ua.org.dancegrouptracker.dao;

import ua.org.dancegrouptracker.model.*;

import java.util.List;

/**
 * Created by SeVlad on 09.05.2017.
 */
public interface UserGroupRoleDao {

    UserGroupRoleKey saveOrUpdate(UserGroupRole userGroupRole);

    void delete(UserGroupRole userGroupRole);

    List<UserGroupRole> getAllByGroup(Group group);

    List<UserGroupRole> getAllByUser(User user);

    List<UserGroupRole> getAllByGroupRole(GroupRole groupRole);

    List<UserGroupRole> getAll();
}
