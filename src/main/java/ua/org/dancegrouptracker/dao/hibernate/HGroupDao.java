package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.GroupDao;
import ua.org.dancegrouptracker.model.Group;

import java.util.List;

/**
 * Created by SeVlad on 02.05.2017.
 */
public class HGroupDao implements GroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Group getGroupByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public Group read(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Long saveOrUpdate(Group transientObject) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Group persistentObject) {

    }

    @Override
    @Transactional
    public List<Group> getAll() {
        return null;
    }
}
