package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RoleDao;
import ua.org.dancegrouptracker.model.Role;

import java.util.List;

/**
 * Created by SeVlad on 14.03.2017.
 */
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public Role getRolesById(Long id){
        return roleDao.read(id);
    }

    @Transactional
    public Long saveOrUpdateRole(Role role){
        return roleDao.saveOrUpdate(role);
    }

    @Transactional
    public List<Role> getAllRoles(){
        return roleDao.getAll();
    }

    @Transactional
    public void deleteRoles(Role role){
        roleDao.delete(role);
    }

    @Transactional
    public Role getRolesByName(String name){
        return roleDao.getRolesByName(name);
    }
}
