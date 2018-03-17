package ua.org.dancegrouptracker.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
@Setter
public class UserGroupRoleService {
    @Autowired
    private UserGroupRoleDao userGroupRoleDao;

    @Transactional
    public Long saveOrUpdateGroup(UserGroupRole userGroupRole) {
        userGroupRoleDao.save(userGroupRole);
        return userGroupRole.getId();
    }

    @Transactional
    public void deleteGroup(UserGroupRole userGroupRole) {
        userGroupRoleDao.delete(userGroupRole);
    }

    @Transactional
    public UserGroupRole findGroupById(Long id) {
        return userGroupRoleDao.findOne(id);
    }

    @Transactional
    public List<UserGroupRole> getAllGroups() {
        return userGroupRoleDao.findAll();
    }

    @Transactional
    public List<User> getAllUsersFromGroup(Group group) {
        List<UserGroupRole> list = userGroupRoleDao.findByGroup(group);
        return list.stream()
                .map(UserGroupRole::getUser)
                .distinct()
                .collect(Collectors.toList());
    }

    @Transactional
    public List<User> getAllUsersFromGroup(Group group, GroupRole role) {
        List<UserGroupRole> list = userGroupRoleDao.findByGroup(group);
        return list.stream()
                .filter(u -> u.getGroupRole() == role)
                .map(UserGroupRole::getUser)
                .distinct()
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Group> getAllGroupsFromUser(User user) {
        List<UserGroupRole> list = userGroupRoleDao.findByUser(user);
        return list.stream()
                .map(UserGroupRole::getGroup)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Group> getAllGroupsFromUser(User user, GroupRole role) {
        List<UserGroupRole> list = userGroupRoleDao.findByUser(user);
        return list.stream()
                .filter(u -> u.getGroupRole() == role)
                .map(UserGroupRole::getGroup)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean checkUserGroupRole(User user, Group group, GroupRole role) {
        List<UserGroupRole> list = userGroupRoleDao.findByUserAndGroupAndGroupRole(user, group, role);
        return list.size() > 0L;
    }
}
