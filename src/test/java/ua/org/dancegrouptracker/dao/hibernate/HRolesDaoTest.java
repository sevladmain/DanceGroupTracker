package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RolesDao;
import ua.org.dancegrouptracker.model.Roles;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by SeVlad on 13.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-database-config-test.xml")
public class HRolesDaoTest {
    @Autowired
    private RolesDao rolesDao;

    private Roles newRole, existingRole;

    @Before
    public void setUp() throws Exception {
        newRole = new Roles();
        existingRole = new Roles();
        existingRole.setId(1l);
        existingRole.setRoleName("ROLE_USER");
        newRole.setRoleName("ROLE_ADMIN");
    }

    @Test
    @Transactional
    @Rollback
    public void checkIfOnlyOneRolesInDB(){
        List<Roles> roles = rolesDao.getAll();
        assertThat(roles.size(), equalTo(1));
        assertEquals(roles.get(0), existingRole);
    }

    @Test
    @Transactional
    @Rollback
    public void saveNewRole(){
        rolesDao.saveOrUpdate(newRole);
        assertThat(newRole.getId(), equalTo(2L));
    }

    @Test
    @Transactional
    @Rollback
    public void saveExistingRole(){
        newRole.setId(existingRole.getId());
        rolesDao.saveOrUpdate(newRole);
        List<Roles> roles = rolesDao.getAll();
        assertThat(roles.size(), equalTo(1));
        assertThat(roles.get(0), equalTo(newRole));
    }

    @Test
    @Transactional
    @Rollback
    public void deleteRoleTest(){
        newRole.setId(2L);
        rolesDao.delete(newRole);
        List<Roles> roles = rolesDao.getAll();
        assertThat("Roles should not change if delete non existing Role from DB",
                roles.size(), equalTo(1));

        rolesDao.delete(roles.get(0));
        roles = rolesDao.getAll();
        assertThat("Roles should be zero if deleted only one existing Role",
                roles.size(), equalTo(0));
    }

}