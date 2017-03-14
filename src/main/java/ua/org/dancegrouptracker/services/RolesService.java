package ua.org.dancegrouptracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RolesDao;
import ua.org.dancegrouptracker.model.Roles;

import java.util.List;

/**
 * Created by SeVlad on 14.03.2017.
 */
public class RolesService {
    @Autowired
    private RolesDao rolesDao;

    public void setRolesDao(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }

    @Transactional
    public Roles getRolesById(Long id){
        return rolesDao.read(id);
    }

    @Transactional
    public Long saveOrUpdateRole(Roles roles){
        return rolesDao.saveOrUpdate(roles);
    }

    @Transactional
    public List<Roles> getAllRoles(){
        return rolesDao.getAll();
    }

    @Transactional
    public void deleteRoles(Roles roles){
        rolesDao.delete(roles);
    }
}
