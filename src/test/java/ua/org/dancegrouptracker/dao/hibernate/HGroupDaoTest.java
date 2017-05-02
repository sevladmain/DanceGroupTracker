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
import ua.org.dancegrouptracker.dao.GroupDao;
import ua.org.dancegrouptracker.model.Group;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by SeVlad on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/spring-database-config.xml"})
@ActiveProfiles({"test"})
public class HGroupDaoTest {
    @Autowired
    private GroupDao groupDao;

    private Group group;

    @Before
    public void setUp() throws Exception {
        group = new Group();
        group.setName("TestGroup2");
        group.setDescription("This is TestGroup2");
    }

    @Test
    @Transactional
    @Rollback
    public void checkUpdatingGroup(){
        group.setId(1L);
        assertThat(groupDao.saveOrUpdate(group), equalTo(group.getId()));
        List<Group> groups = groupDao.getAll();
        assertThat("Wrong size of Saved Group Array", groups.size(), equalTo(1));
        assertEquals("Saved groups not equal", group, groups.get(0));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAllGroups() {
        List<Group> users = groupDao.getAll();
        assertThat("Groups not 1", users.size(), equalTo(1));
        assertThat("Group.ID is not the same as in DB", users.get(0).getId(), equalTo(1L));
        assertThat("Group.NAME not the same as in DB", users.get(0).getName(), equalTo("TestGroup1"));
        assertThat("Group.DESCRIPTION not the same as in DB", users.get(0).getDescription(), equalTo("This is TestGroup1"));
    }


}