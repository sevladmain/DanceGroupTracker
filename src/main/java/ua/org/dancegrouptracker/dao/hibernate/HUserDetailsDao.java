package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDetailsDao;
import ua.org.dancegrouptracker.model.UserDetails;

import java.util.List;

/**
 * Created by SeVlad on 14.04.2017.
 */
public class HUserDetailsDao implements UserDetailsDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public UserDetails read(String id) {
        return sessionFactory.getCurrentSession().get(UserDetails.class, id);
    }

    @Override
    @Transactional
    public String saveOrUpdate(UserDetails userDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userDetails);
        session.flush();
        return userDetails.getUsername();
    }

    @Override
    @Transactional
    public void delete(UserDetails userDetails) {
        sessionFactory.getCurrentSession().delete(userDetails);
    }

    @Override
    @Transactional
    public List<UserDetails> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select ud from UserDetails ud");
        return query.list();
    }
}
