package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.Group;
import ua.org.dancegrouptracker.model.GroupRole;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.model.UserGroupRole;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public List<User> getAllUsersFromGroup(Group group) {
        List<UserGroupRole> list = userGroupRoleDao.getAllByGroup(group);
        List<User> users = list.stream()
                                .map(u -> u.getUser())
                                .distinct()
                                .collect(Collectors.toList());
        return users;
    }

    @Transactional
    public List<User> getAllUsersFromGroup(Group group, GroupRole role) {
        List<UserGroupRole> list = userGroupRoleDao.getAllByGroup(group);
        List<User> users = list.stream()
                .filter(u -> u.getGroupRole() == role)
                .map(u -> u.getUser())
                .distinct()
                .collect(Collectors.toList());
        return users;
    }
}
