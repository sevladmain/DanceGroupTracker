package ua.org.dancegrouptracker.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;

/**
 * Created by SeVlad on 30.03.2017.
 */

public class UserTest {

    private static Validator validator;

    private User correctUser;

    @BeforeClass
    public static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Before
    public void init(){
        correctUser = new User();
        correctUser.setUsername("testtest");
        correctUser.setEmail("test@test.org");
        correctUser.setPassword("password123");
    }
    @Test
    public void setIncorrectUserName(){
        correctUser.setUsername("abc");
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(correctUser);

        assertThat(constraintViolationSet.size(), equalTo(2));

        constraintViolationSet
                .forEach(t -> assertThat(t.getMessageTemplate(), anyOf(equalTo("{javax.validation.constraints.Pattern.message}"),equalTo("{javax.validation.constraints.Size.message}"))));
    }

    //TODO: add a set of test with various Emails
    @Test
    public void setIncorrectEmail(){
        correctUser.setEmail("test@test");
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(correctUser);

        assertThat(constraintViolationSet.size(), equalTo(1));
        assertThat(constraintViolationSet.iterator().next().getMessageTemplate(), equalTo("Email.user.email"));
    }

}