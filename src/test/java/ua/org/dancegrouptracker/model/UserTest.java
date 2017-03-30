package ua.org.dancegrouptracker.model;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SeVlad on 30.03.2017.
 */

public class UserTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void setIncorrectUserName(){
        User user = new User();
        user.setUsername("abc");
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);

        assertThat(constraintViolationSet.size(), equalTo(1));
        assertThat(constraintViolationSet.iterator().next().getMessage(), equalTo("bbb"));

    }

}