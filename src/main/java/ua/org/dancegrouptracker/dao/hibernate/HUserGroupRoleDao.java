package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by SeVlad on 09.05.2017.
 */
public class HUserGroupRoleDao implements UserGroupRoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public UserGroupRoleKey saveOrUpdate(UserGroupRole userGroupRole) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userGroupRole);
        currentSession.flush();
        return userGroupRole.getKey();
    }

    @Override
    @Transactional
    public void delete(UserGroupRole userGroupRole) {

    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByGroup(Group group) {
        return null;
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByUser(User user) {
        return null;
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByGroupRole(GroupRole groupRole) {
        return null;
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select ugr from UserGroupRole ugr");
        return query.getResultList();
    }
}
