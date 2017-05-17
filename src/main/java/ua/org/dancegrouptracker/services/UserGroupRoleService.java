package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.UserGroupRole;

import java.util.List;

/**
 * Created by SeVlad on 16.05.2017.
 */
public class UserGroupRoleService {
    @Autowired
    private UserGroupRoleDao userGroupRoleDao;

    @Transactional
    public Long saveOrUpdateGroup(UserGroupRole userGroupRole) {
        return userGroupRoleDao.saveOrUpdate(userGroupRole);
    }

    @Transactional
    public void deleteGroup(UserGroupRole userGroupRole) {
        userGroupRoleDao.delete(userGroupRole);
    }

    @Transactional
    public UserGroupRole findGroupById(Long id) {
        return userGroupRoleDao.read(id);
    }

    @Transactional
    public List<UserGroupRole> getAllGroups() {
        return userGroupRoleDao.getAll();
    }
}
