package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RoleDao;
import ua.org.dancegrouptracker.model.Role;

import java.util.List;

/**
 * Created by SeVlad on 13.03.2017.
 */
public class HRoleDao implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Role read(Long id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    @Transactional
    public Long saveOrUpdate(Role role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        return role.getId();
    }

    @Override
    @Transactional
    public void delete(Role role) {
        if(read(role.getId()) != null) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select r from Role r");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Role getRolesByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.roleName=:name");
        query.setParameter("name", name);
        return (Role) query.uniqueResult();
    }
}
