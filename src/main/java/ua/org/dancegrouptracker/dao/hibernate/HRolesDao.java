package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.org.dancegrouptracker.dao.RolesDao;
import ua.org.dancegrouptracker.model.Roles;

import java.util.List;

/**
 * Created by SeVlad on 13.03.2017.
 */
public class HRolesDao implements RolesDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Roles read(String id) {
        return null;
    }

    @Override
    public String saveOrUpdate(Roles transientObject) {
        return null;
    }

    @Override
    public void delete(Roles persistentObject) {

    }

    @Override
    public List<Roles> getAll() {
        return null;
    }
}
