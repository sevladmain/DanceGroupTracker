package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.UserDao;
import ua.org.dancegrouptracker.model.Role;
import ua.org.dancegrouptracker.model.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.org.dancegrouptracker.model.RoleType.ROLE_USER;

/**
 * Created by SeVlad on 12.03.2017.
 * Tests for HUserDao class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-database-config.xml"})
@ActiveProfiles({"test"})
public class HUserDaoTest {

    @Autowired
    UserDao userDao;

    private User user;

    @Before
    public void setUp() throws Exception {
        Role role = new Role();
        role.setId(1l);
        role.setRoleName(ROLE_USER.name());
        user = new User();
        user.setUsername("testUser");
        user.setAuthority(role);
        user.setDateRegister(LocalDate.of(2017, 1, 1));
        user.setEmail("test@test.org");
        user.setEnabled(true);
        user.setEncodedPassword("123");
    }

    @Test
    @Transactional
    @Rollback
    public void sameUsernameAfterSaveUserInLowerCase(){
        String username =  userDao.saveOrUpdate(user);
        assertEquals(username, user.getUsername());
    }

    @Test
    @Transactional
    @Rollback
    public void checkUpdatingUser(){
        user.setUsername("user1");
        userDao.saveOrUpdate(user);
        List<User> users = userDao.getAll();
        assertThat("Wrong size of Saved User Array", users.size(), equalTo(1));
        assertEquals("Saved users not equal", user, users.get(0));
    }

    @Test
    @Transactional
    @Rollback
    public void checkIfUserWasSaved(){
        userDao.saveOrUpdate(user);
        List<User> users = userDao.getAll();
        assertThat("Wrong size of Saved User Array", users.size(), equalTo(2));
        assertEquals("Saved users not equal", user, users.get(0));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAllUsers(){
        List<User> users = userDao.getAll();
        assertThat("Users not 1", users.size(), equalTo(1));
        assertThat("Users not the same as in DB", users.get(0).getUsername(), equalTo("user1"));
    }

    @Test
    @Transactional
    @Rollback
    public void readSavedUser(){
        userDao.saveOrUpdate(user);
        User userDouble = userDao.read(user.getUsername());
        assertEquals(userDouble, user);
    }

    @Test
    @Transactional
    @Rollback
    public void readExistingUser(){
        User userDouble = userDao.read("user1");
        assertThat(userDouble.getEmail(), equalTo("test@t.t"));
    }

    @Test
    @Transactional
    @Rollback
    public void readNotExistingUser(){
        User userDouble = userDao.read("bla-bla-bla");
        assertEquals(null, userDouble);
    }

    @Test
    @Transactional
    @Rollback
    public void deleteUserTest(){
        List<User> users = userDao.getAll();
        user = users.get(0);
        userDao.delete(user);
        users = userDao.getAll();
        assertThat(users.size(), equalTo(0));
    }
}