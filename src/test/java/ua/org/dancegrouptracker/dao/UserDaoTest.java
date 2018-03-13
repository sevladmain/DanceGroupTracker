package ua.org.dancegrouptracker.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.org.dancegrouptracker.model.Role;
import ua.org.dancegrouptracker.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ua.org.dancegrouptracker.model.RoleType.ROLE_USER;

/**
 * Created by SeVlad on 12.03.2017.
 * Tests for HUserDao class
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testGetUserByEmail() {
        Role role = new Role();
        role.setRoleName(ROLE_USER);
        User user = new User();
        user.setUsername("testUser");
        user.setAuthority(role);
        user.setDateRegister(LocalDate.of(2017, 1, 1));
        user.setEmail("test@test.org");
        user.setEnabled(true);
        user.setEncodedPassword("12345678");
        user.setPassword("12345678");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.forEach(entityManager::persistAndFlush);

        List<User> dbUserList = userDao.getUserByEmail("test@test.org");
        assertEquals("Users are not equals:", userList, dbUserList);
    }
}