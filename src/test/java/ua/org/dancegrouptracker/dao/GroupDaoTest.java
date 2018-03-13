package ua.org.dancegrouptracker.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.org.dancegrouptracker.model.Group;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by SeVlad on 02.05.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupDaoTest {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findGroupByName(){
        List<Group> testGroupDataList = new ArrayList<>();
        Group group = new Group();
        group.setName("TestGroup1");
        group.setDescription("This is TestGroup1");
        entityManager.persistAndFlush(group);
        testGroupDataList.add(group);

        List<Group> repositoryItemList = groupDao.getGroupByNameLike("%Group%");

        assertEquals("Finded item list size should be 1", 1, repositoryItemList.size());
        assertEquals("Finded item with group name and saved item not equal", repositoryItemList.get(0), testGroupDataList.get(0));
    }

}