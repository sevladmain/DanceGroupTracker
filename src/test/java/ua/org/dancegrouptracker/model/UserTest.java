package ua.org.dancegrouptracker.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;

/**
 * Created by SeVlad on 30.03.2017.
 */
@RunWith(Parameterized.class)
public class UserTest {

    private static Validator validator;

    private User correctUser;

    @Parameters(name = "{index}: emailTemplate = {0} and number of errors is {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"test@test", 1},
                {"test@", 1},
                {"test", 1},
                {"test@test.org", 0},
                {"test@test.org.ua", 0},
                {"test-t.1252@test.org", 0}
        });
    }
    private String emailTemplate;
    private int expectedErrors;

    public UserTest(String emailTemplate, int expectedErrors){
        this.emailTemplate = emailTemplate;
        this.expectedErrors = expectedErrors;
    }

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


    @Test
    public void checkingEmailTemplates(){
        correctUser.setEmail(emailTemplate);
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(correctUser);

        assertThat(constraintViolationSet.size(), equalTo(expectedErrors));
        if(expectedErrors > 0) {
            assertThat(constraintViolationSet.iterator().next().getMessageTemplate(), equalTo("Email.user.email"));
        }
    }
}