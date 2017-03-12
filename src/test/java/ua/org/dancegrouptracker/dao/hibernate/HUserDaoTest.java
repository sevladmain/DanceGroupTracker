package ua.org.dancegrouptracker.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.org.dancegrouptracker.model.Authorities;
import ua.org.dancegrouptracker.model.User;

import java.sql.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by SeVlad on 12.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HUserDaoTest {
    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    private HUserDao userDao;
    private User user;

    @Before
    public void setUp() throws Exception {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        userDao = new HUserDao();
        userDao.setSessionFactory(sessionFactory);
        Authorities authorities = new Authorities();
        authorities.setRoleName("USR_TEST");
        user = new User();
        user.setUsername("testUser");
        user.setAuthority(authorities);
        user.setDateRegister(Date.valueOf("2017-01-01"));
        user.setEmail("test@test.org");
        user.setEnabled(true);
        user.setPassword("123");
    }

    @Test
    public void saveUser(){
        userDao.saveOrUpdate(user);
        verify(session, times(1)).save(user);
    }

}