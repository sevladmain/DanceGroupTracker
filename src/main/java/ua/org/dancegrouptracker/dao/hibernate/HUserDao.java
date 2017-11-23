package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.model.User;

import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */

public class HUserDao implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User read(String id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public String saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        return user.getUsername();
    }

    @Override
    @Transactional
    public void delete(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
        currentSession.flush();
    }

    @Override
    @Transactional
    public List<User> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from User u");
        return query.list();
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.email=:email");
        query.setParameter("email", email);
        return (User) query.uniqueResult();
    }
}
