package ua.org.dancegrouptracker.dao.hibernate;

import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.Group;
import ua.org.dancegrouptracker.model.GroupRole;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.model.UserGroupRole;

import java.util.List;

/**
 * Created by SeVlad on 09.05.2017.
 */
public class HUserGroupRoleDao implements UserGroupRoleDao {
    @Override
    public boolean saveOrUpdate(UserGroupRole userGroupRole) {
        return false;
    }

    @Override
    public void delete(UserGroupRole userGroupRole) {

    }

    @Override
    public List<UserGroupRole> getAllByGroup(Group group) {
        return null;
    }

    @Override
    public List<UserGroupRole> getAllByUser(User user) {
        return null;
    }

    @Override
    public List<UserGroupRole> getAllByGroupRole(GroupRole groupRole) {
        return null;
    }
}
