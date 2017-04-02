package ua.org.dancegrouptracker.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SeVlad on 02.04.2017.
 */
@RunWith(Parameterized.class)
public class UserValidationTest {
    @Parameterized.Parameters(name = "{index}: u={0}, em={1}, pas={2}, er={3}, mes={4}")
    public static Collection<Object[]> data() {
        //TODO: add user validation test for other choices
        //username, email, password, expectedErrors, templateError
        return Arrays.asList(new Object[][]{
                {"testtest", "test@test", "password123", 1, "Email.user.email"},
                {"testtest", "test@", "password123", 1, "Email.user.email"},
                {"testtest", "test", "password123", 1, "Email.user.email"},
                {"testtest", "test@test.org", "password123", 0, ""},
                {"testtest", "test@test.org.ua", "password123", 0, ""},
                {"testtest", "test-t.1252@test.org", "password123", 0, ""},
                {"abc", "test@test.org.ua", "password123", 2, "{javax.validation.constraints.Pattern.message}"},
                {"abc", "test@test.org.ua", "password123", 2, "{javax.validation.constraints.Size.message}"}
        });
    }

    private String username;

    private String email;

    private String password;

    private int expectedErrors;

    private String templateError;

    private static Validator validator;

    private User testedUser;


    public UserValidationTest(String username, String email, String password,
                              int expectedErrors, String templateError) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.expectedErrors = expectedErrors;
        this.templateError = templateError;
    }

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void init() {
        testedUser = new User();
        testedUser.setUsername(username);
        testedUser.setEmail(email);
        testedUser.setPassword(password);
    }

    @Test
    public void checkingEmailTemplates() {

        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(testedUser);

        assertThat(constraintViolationSet.size(), equalTo(expectedErrors));
        if (expectedErrors > 0) {
            assertThat(constraintViolationSet
                            .stream()
                            .filter(t -> t.getMessageTemplate().equals(templateError))
                            .count(),
                    equalTo(1L));
        }
    }
}
