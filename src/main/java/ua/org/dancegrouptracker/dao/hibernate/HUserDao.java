package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.model.User;

import org.hibernate.query.Query;
import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
// TODO: perform test on HUserDao
// TODO: implement methods in HUserDao
public class HUserDao implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User read(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select s from User s where s.username = :id");
        query.setParameter("id", id);
        User user = (User) query.uniqueResult();
        if (user == null){
            return new User();
        }
        return user;
    }

    @Override
    @Transactional
    public String saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getUsername();
    }

    @Override
    @Transactional
    public void delete(User persistentObject) {

    }

    @Override
    @Transactional
    public List<User> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from User u");
        return query.getResultList();
    }
}
