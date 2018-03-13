package ua.org.dancegrouptracker.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.org.dancegrouptracker.model.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by SeVlad on 09.05.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserGroupRoleDaoTest {
    @Autowired
    private UserGroupRoleDao userGroupRoleDao;

    @Autowired
    private TestEntityManager entityManager;

    private UserGroupRole userGroupRole;

    @Before
    public void setUp(){
        userGroupRole = new UserGroupRole();
        userGroupRole.setId(1L);
        Role role = new Role();
        role.setRoleName(RoleType.ROLE_USER);
        User user =  new User();
        user.setUsername("user1");
        user.setAuthority(role);
        user.setEncodedPassword("user1user1");
        user.setPassword("user1user1");
        user.setEnabled(true);
        user.setEmail("test@t.t");
        user.setDateRegister(LocalDate.of(2010, 1, 1));
        userGroupRole.setUser(user);
        Group group = new Group();
        group.setName("TestGroup1");
        group.setDescription("This is TestGroup1");

        userGroupRole.setGroup(group);
        userGroupRole.setGroupRole(GroupRole.TREASURER);
        userGroupRole.setDateFrom(LocalDate.of(2010, 1, 1));
        userGroupRole.setDateTo(LocalDate.of(2099,1,1));

        entityManager.persistAndFlush(userGroupRole);
    }

    @Test
    public void testFindByGroup() {
        List<UserGroupRole> dbEntity = userGroupRoleDao.findByGroup(userGroupRole.getGroup());

        assertThat(dbEntity.size(), equalTo(1));
        assertThat(dbEntity, hasItem(userGroupRole));
    }

    @Test
    public void testFindByUser(){
        List<UserGroupRole> dbEntity = userGroupRoleDao.findByUser(userGroupRole.getUser());

        assertThat(dbEntity.size(), equalTo(1));
        assertThat(dbEntity, hasItem(userGroupRole));
    }

    @Test
    public void testFindByGroupRole(){
        List<UserGroupRole> dbEntity = userGroupRoleDao.findByGroupRole(userGroupRole.getGroupRole());

        assertThat(dbEntity.size(), equalTo(1));
        assertThat(dbEntity, hasItem(userGroupRole));
    }

    @Test
    public void testFindByUserAndGroupAndGroupRole(){
        List<UserGroupRole> dbEntity = userGroupRoleDao
                .findByUserAndGroupAndGroupRole(userGroupRole.getUser(),
                        userGroupRole.getGroup(),
                        userGroupRole.getGroupRole());

        assertThat(dbEntity.size(), equalTo(1));
        assertThat(dbEntity, hasItem(userGroupRole));
    }
}