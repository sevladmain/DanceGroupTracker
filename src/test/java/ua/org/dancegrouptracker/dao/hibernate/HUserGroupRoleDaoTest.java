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
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by SeVlad on 09.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/spring-database-config.xml"})
@ActiveProfiles({"test"})
public class HUserGroupRoleDaoTest {
    @Autowired
    private UserGroupRoleDao userGroupRoleDao;

    private UserGroupRole userGroupRole;

    @Before
    public void setUp(){
        //INSERT INTO USERGROUPROLE(username, groupid, datefrom, dateto, grouprole)
        // VALUES ('user1', 1, '2010-01-01', '2099-01-01', 'TREASURER');
        userGroupRole = new UserGroupRole();
        //INSERT INTO users VALUES ('user1', 'user1', TRUE, 'test@t.t', '2010-01-01');
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(RoleType.ROLE_USER);
        User user =  new User();
        user.setUsername("user1");
        user.setAuthority(role);
        user.setEncodedPassword("user1");
        user.setEnabled(true);
        user.setEmail("test@t.t");
        user.setDateRegister(LocalDate.of(2010, 1, 1));
        userGroupRole.setUser(user);
        //INSERT INTO GROUPS (name, description) VALUES ('TestGroup1', 'This is TestGroup1');
        Group group = new Group();
        group.setId(1L);
        group.setName("TestGroup1");
        group.setDescription("This is TestGroup1");
        userGroupRole.setGroup(group);
        userGroupRole.setGroupRole(GroupRole.TREASURER);
        userGroupRole.setDateFrom(LocalDate.of(2010, 1, 1));
        userGroupRole.setDateTo(LocalDate.of(2099,1,1));
    }

    @Test
    @Rollback
    @Transactional
    public void testSaveUserGroupRole(){
        userGroupRole.setDateFrom(LocalDate.of(2009, 1, 1));
        userGroupRole.setDateTo(LocalDate.of(2009, 12, 31));
        userGroupRole.setGroupRole(GroupRole.MANAGER);
        userGroupRoleDao.saveOrUpdate(userGroupRole);
        List<UserGroupRole> roles = userGroupRoleDao.getAll();
        assertThat("Wrong size of Saved Group Array", roles.size(), equalTo(2));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteSavedUserGroupRole(){
        userGroupRole.setDateFrom(LocalDate.of(2009, 1, 1));
        userGroupRole.setDateTo(LocalDate.of(2009, 12, 31));
        userGroupRole.setGroupRole(GroupRole.MANAGER);
        userGroupRoleDao.saveOrUpdate(userGroupRole);
        userGroupRoleDao.delete(userGroupRole);
        List<UserGroupRole> roles = userGroupRoleDao.getAll();
        assertThat("Wrong size of Saved Group Array", roles.size(), equalTo(1));
    }

    @Test
    @Rollback
    @Transactional
    public void getAllUserGroupRoleForTestGroup(){
        List<UserGroupRole> allByGroup = userGroupRoleDao.getAllByGroup(userGroupRole.getGroup());
        assertThat(allByGroup.size(), equalTo(1));
        assertThat(allByGroup.get(0), equalTo(userGroupRole));
    }

    @Test
    @Rollback
    @Transactional
    public void getUserGroupRoleByTestUser(){
        List<UserGroupRole> allByGroup = userGroupRoleDao.getAllByUser(userGroupRole.getUser());
        assertThat(allByGroup.size(), equalTo(1));
        assertThat(allByGroup.get(0), equalTo(userGroupRole));
    }

    @Test
    @Rollback
    @Transactional
    public void getUserGroupRoleByGroupRole(){
        List<UserGroupRole> allByGroup = userGroupRoleDao.getAllByGroupRole(userGroupRole.getGroupRole());
        assertThat(allByGroup.size(), equalTo(1));
        assertThat(allByGroup.get(0), equalTo(userGroupRole));
    }

}