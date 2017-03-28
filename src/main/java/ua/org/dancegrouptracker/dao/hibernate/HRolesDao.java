package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RolesDao;
import ua.org.dancegrouptracker.model.Roles;

import java.util.List;

/**
 * Created by SeVlad on 13.03.2017.
 */
public class HRolesDao implements RolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Roles read(Long id) {
        return sessionFactory.getCurrentSession().get(Roles.class, id);
    }

    @Override
    @Transactional
    public Long saveOrUpdate(Roles role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        return role.getId();
    }

    @Override
    @Transactional
    public void delete(Roles role) {
        if(read(role.getId()) != null) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    @Override
    @Transactional
    public List<Roles> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select r from Roles r");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Roles getRolesByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select r from Roles r where r.roleName=:name");
        query.setParameter("name", name);
        return (Roles) query.uniqueResult();
    }
}
