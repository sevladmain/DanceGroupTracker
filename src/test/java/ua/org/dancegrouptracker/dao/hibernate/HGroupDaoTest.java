package ua.org.dancegrouptracker.dao.hibernate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.org.dancegrouptracker.dao.GroupDao;
import ua.org.dancegrouptracker.model.Group;

import java.time.LocalDate;

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


}