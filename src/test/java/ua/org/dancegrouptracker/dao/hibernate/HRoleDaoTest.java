package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.org.dancegrouptracker.dao.RoleDao;
import ua.org.dancegrouptracker.model.Role;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.org.dancegrouptracker.model.RoleType.ROLE_ADMIN;
import static ua.org.dancegrouptracker.model.RoleType.ROLE_USER;

/**
 * Created by SeVlad on 13.03.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/spring-database-config.xml"})
@ActiveProfiles({"test"})
public class HRoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    private Role newRole, existingRole;

    @Before
    public void setUp() throws Exception {
        newRole = new Role();
        existingRole = new Role();
        existingRole.setId(1l);
        existingRole.setRoleName(ROLE_USER);
        newRole.setRoleName(ROLE_ADMIN);
    }

    @Test
    @Transactional
    @Rollback
    public void checkIfOnlyOneRolesInDB(){
        List<Role> roles = roleDao.getAll();
        assertThat(roles.size(), equalTo(2));
        assertEquals(roles.get(0), existingRole);
    }

    @Test
    @Transactional
    @Rollback
    public void saveNewRole(){
        roleDao.saveOrUpdate(newRole);
        assertThat(newRole.getId(), equalTo(3L));
    }

    @Test
    @Transactional
    @Rollback
    public void saveExistingRole(){
        newRole.setId(existingRole.getId());
        roleDao.saveOrUpdate(newRole);
        List<Role> roles = roleDao.getAll();
        assertThat(roles.size(), equalTo(2));
        assertThat(roles.get(0), equalTo(newRole));
    }

    @Test
    @Transactional
    @Rollback
    public void readRoleFromDb(){
        Role role = roleDao.read(1L);
        assertThat("Readed and existing Role should be equal", role, equalTo(existingRole));
    }

    @Test
    @Transactional
    @Rollback
    public void deleteRoleTest(){
        newRole.setId(3L);
        roleDao.delete(newRole);
        List<Role> roles = roleDao.getAll();
        assertThat("Role should not change if delete non existing Role from DB",
                roles.size(), equalTo(2));

        roleDao.delete(roles.get(1));
        roles = roleDao.getAll();
        assertThat("Role should be zero if deleted only one existing Role",
                roles.size(), equalTo(1));
    }

    @Test
    @Transactional
    @Rollback
    public void findRolesByName(){
        Role roleUser = roleDao.getRolesByName(ROLE_USER.name());
        assertThat(roleUser, equalTo(existingRole));
    }

}