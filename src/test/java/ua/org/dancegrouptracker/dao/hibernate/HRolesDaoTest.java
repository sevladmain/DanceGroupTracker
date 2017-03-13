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

}