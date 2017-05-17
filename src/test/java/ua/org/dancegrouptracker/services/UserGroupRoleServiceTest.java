package ua.org.dancegrouptracker.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.org.dancegrouptracker.dao.UserGroupRoleDao;
import ua.org.dancegrouptracker.model.Group;
import ua.org.dancegrouptracker.model.GroupRole;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.model.UserGroupRole;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by SeVlad on 17.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserGroupRoleServiceTest {

    @Mock
    private UserGroupRoleDao dao;

    @InjectMocks
    private UserGroupRoleService service;

    private List<UserGroupRole> results;

    @Before
    public void setUp() {
        results = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");
        Group group1 = new Group();
        group1.setId(1L);
        Group group2 = new Group();
        group1.setId(2L);
        UserGroupRole data1 = new UserGroupRole();
        data1.setId(1L);
        data1.setUser(user1);
        data1.setGroup(group1);
        data1.setGroupRole(GroupRole.MANAGER);
        results.add(data1);

        UserGroupRole data2 = new UserGroupRole();
        data2.setId(2L);
        data2.setUser(user1);
        data2.setGroup(group2);
        data2.setGroupRole(GroupRole.MANAGER);
        results.add(data2);

        UserGroupRole data3 = new UserGroupRole();
        data3.setId(3L);
        data3.setUser(user2);
        data3.setGroup(group1);
        data3.setGroupRole(GroupRole.MEMBER);
        results.add(data3);

        UserGroupRole data4 = new UserGroupRole();
        data4.setId(4L);
        data4.setUser(user2);
        data4.setGroup(group2);
        data4.setGroupRole(GroupRole.TREASURER);
        results.add(data4);
    }

    @Test
    public void getAllUsersFromGroupTest() {
        results.remove(3);
        results.remove(1);
        Group group = results.get(0).getGroup();
        when(dao.getAllByGroup(group)).thenReturn(results);
        List<User> users = service.getAllUsersFromGroup(group);
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user2");

        assertThat(users.size(), equalTo(2));
        assertThat(users, contains(equalTo(user1), equalTo(user2)));

    }

}