package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

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
        User user =  new User();
        user.setUsername("user1");
        user.setPassword("user1");
        user.setEnabled(true);
        user.setEmail("test@t.t.");
        user.setDateRegister(LocalDate.of(2017, 1, 1));
        userGroupRole.getKey().setUser(user);
        //INSERT INTO GROUPS (name, description) VALUES ('TestGroup1', 'This is TestGroup1');
        Group group = new Group();
        group.setId(1L);
        group.setName("TestGroup1");
        group.setDescription("This is TestGroup1");
        userGroupRole.getKey().setGroup(group);
        userGroupRole.setGroupRole(GroupRole.TREASURER);
        userGroupRole.getKey().setDateFrom(LocalDate.of(2010, 1, 1));
        userGroupRole.getKey().setDateTo(LocalDate.of(2099,1,1));
    }
    @Test
    public void testSaveUserGroupRole(){

    }
}