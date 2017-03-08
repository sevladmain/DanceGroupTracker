package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.model.User;

import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
// TODO: perform test on HUserDao
// TODO: implement methods in HUserDao
public class HUserDao implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User read(String id) {
        return null;
    }

    @Override
    public String saveOrUpdate(User transientObject) {
        return null;
    }

    @Override
    public void delete(User persistentObject) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
