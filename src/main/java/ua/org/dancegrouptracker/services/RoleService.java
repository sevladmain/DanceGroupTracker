package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RoleDao;
import ua.org.dancegrouptracker.model.Role;
import ua.org.dancegrouptracker.model.RoleType;

import java.util.List;

/**
 * Created by SeVlad on 14.03.2017.
 */
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public Role getRolesById(Long id){
        return roleDao.findOne(id);
    }

    @Transactional
    public Long saveOrUpdateRole(Role role){
        roleDao.save(role);
        return role.getId();
    }

    @Transactional
    public List<Role> getAllRoles(){
        return roleDao.findAll();
    }

    @Transactional
    public void deleteRoles(Role role){
        roleDao.delete(role);
    }

    @Transactional
    public Role getRolesByName(String name){
        List<Role> roleList = roleDao.findByRoleName(RoleType.valueOf(name));
        return roleList.isEmpty() ? null : roleList.get(0);
    }
}
