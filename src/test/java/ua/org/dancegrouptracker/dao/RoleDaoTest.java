package ua.org.dancegrouptracker.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.org.dancegrouptracker.model.Role;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static ua.org.dancegrouptracker.model.RoleType.ROLE_USER;

/**
 * Created by SeVlad on 13.03.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findRolesByName(){
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleName(ROLE_USER);
        entityManager.persistAndFlush(role);
        roleList.add(role);

        List<Role> roleUser = roleDao.findByRoleName(ROLE_USER);
        assertThat(roleUser, equalTo(roleList));
    }
}