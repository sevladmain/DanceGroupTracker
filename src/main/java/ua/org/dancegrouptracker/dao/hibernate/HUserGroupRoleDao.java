package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
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
    public UserGroupRole read(Long id) {
        return sessionFactory.getCurrentSession().get(UserGroupRole.class, id);
    }

    @Override
    @Transactional
    public Long saveOrUpdate(UserGroupRole userGroupRole) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userGroupRole);
        currentSession.flush();
        return userGroupRole.getId();
    }

    @Override
    @Transactional
    public void delete(UserGroupRole userGroupRole) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(userGroupRole);
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByGroup(Group group) {
        Query query = sessionFactory.getCurrentSession().createQuery("select ugr from UserGroupRole ugr where group = :group");
        query.setParameter("group", group);
        return query.list();
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("select ugr from UserGroupRole ugr where user = :user");
        query.setParameter("user", user);
        return query.list();
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAllByGroupRole(GroupRole groupRole) {
        Query query = sessionFactory.getCurrentSession().createQuery("select ugr from UserGroupRole ugr where groupRole = :groupRole");
        query.setParameter("groupRole", groupRole);
        return query.list();
    }

    @Override
    @Transactional
    public List<UserGroupRole> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("select ugr from UserGroupRole ugr");
        return query.list();
    }
}
