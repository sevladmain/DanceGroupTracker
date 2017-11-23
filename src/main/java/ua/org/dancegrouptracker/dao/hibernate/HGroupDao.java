package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
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
    public List<Group> getGroupByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select g from Group g where g.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public Group read(Long id) {
        return  sessionFactory.getCurrentSession().get(Group.class, id);
    }

    @Override
    @Transactional
    public Long saveOrUpdate(Group group) {
        sessionFactory.getCurrentSession().saveOrUpdate(group);
        return group.getId();
    }

    @Override
    @Transactional
    public void delete(Group group) {
        sessionFactory.getCurrentSession().delete(group);
    }

    @Override
    @Transactional
    public List<Group> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select g from Group g");
        return query.list();
    }
}
