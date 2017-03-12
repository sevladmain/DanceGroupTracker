package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.model.UserRole;
import ua.org.dancegrouptracker.model.User;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by SeVlad on 12.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-database-config-test.xml")
public class HUserDaoTest {

    @Autowired
    UserDao userDao;

    private User user;

    @Before
    public void setUp() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setRoleName("USR_TEST");
        user = new User();
        user.setUsername("testUser");
        user.setAuthority(userRole);
        user.setDateRegister(Date.valueOf("2017-01-01"));
        user.setEmail("test@test.org");
        user.setEnabled(true);
        user.setPassword("123");
    }

    @Test
    @Transactional
    @Rollback
    public void saveUser(){
        String username =  userDao.saveOrUpdate(user);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void readUser(){
        User userDouble = userDao.read(user.getUsername());
        assertEquals(userDouble, user);
    }

}