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
import ua.org.dancegrouptracker.dao.UserDetailsDao;
import ua.org.dancegrouptracker.model.UserDetails;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by SeVlad on 14.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/spring-database-config.xml"})
@ActiveProfiles({"test"})
public class HUserDetailsDaoTest {

    @Autowired
    private UserDetailsDao userDetailsDao;

    private UserDetails userDetails;

    @Before
    public void setUp() throws Exception {
        // INSERT INTO userdetails VALUES ('user1', 'firstname', 'lastname', '1998-01-01');
        /*userDetails = new UserDetails();
        userDetails.setUsername("user1");
        userDetails.setFirstName("firstname");
        userDetails.setLastName("lastname");
        userDetails.setDateOfBirth(LocalDate.of(1998, 1, 1));*/
        userDetails = new UserDetails();
        userDetails.setUsername("user2");
        userDetails.setFirstName("firstname1");
        userDetails.setLastName("lastname1");
        userDetails.setDateOfBirth(LocalDate.of(1999, 1, 1));
    }

    @Test
    @Rollback
    @Transactional
    public void sameUsernameAfterSaveUserDetailsInLowerCase(){
        String username =  userDetailsDao.saveOrUpdate(userDetails);
        assertEquals(username, userDetails.getUsername());
    }


}