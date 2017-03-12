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
import ua.org.dancegrouptracker.model.Roles;
import ua.org.dancegrouptracker.model.User;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        Roles roles = new Roles();
        roles.setRoleName("USR_TEST");
        user = new User();
        user.setUsername("testUser");
        user.setAuthority(roles);
        user.setDateRegister(Date.valueOf("2017-01-01"));
        user.setEmail("test@test.org");
        user.setEnabled(true);
        user.setPassword("123");
    }

    @Test
    @Transactional
    @Rollback
    public void sameUsernameAfterSaveUser(){
        String username =  userDao.saveOrUpdate(user);
        assertEquals(username, user.getUsername());
    }

    @Test
    @Transactional
    @Rollback
    public void checkIfUserWasSaved(){
        userDao.saveOrUpdate(user);
        List<User> users = userDao.getAll();
        assertThat("Wrong size of Saved User Array", users.size(), equalTo(1));
        assertEquals("Saved users not equal", user, users.get(0));
    }

    @Test
    public void readUser(){
        User userDouble = userDao.read(user.getUsername());
        assertEquals(userDouble, user);
    }

}