package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @Override
    public Long saveOrUpdate(Roles role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        return role.getId();
    }

    @Override
    public void delete(Roles persistentObject) {

    }

    @Override
    public List<Roles> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select r from Roles r");
        return query.getResultList();
    }
}
