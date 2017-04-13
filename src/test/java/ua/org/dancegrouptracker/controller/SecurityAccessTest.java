package ua.org.dancegrouptracker.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.services.UserService;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by SeVlad on 18.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:/spring-mvc-config.xml"})
@ActiveProfiles("test")
@WebAppConfiguration
public class SecurityAccessTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Before
    public void setup(){
        LoginController loginController = (LoginController) context.getBean("loginController");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).
                apply(springSecurity()).build();
    }

    @Test
    public void mainPageIsAvaliableForAllUser() throws Exception {
        mockMvc.perform(get("/").with(anonymous()))
                .andExpect(status().isOk());
    }

    @Test
    public void whenLoginPageThatSetupUserForm() throws Exception {
        mockMvc.perform(get("/login").with(anonymous()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", is(new User())))
                .andExpect(model().attribute("isRegister",is(false)));
    }

    @Test
    public void whenAnonymousUserCanRegister() throws Exception{
        User user = new User();
        user.setUsername("test");
        mockMvc.perform(post("/register")
                .param("username", "test")
                .param("password", "testtest")
                .param("email", "test@test.test")
                .with(csrf())
                .with(anonymous()))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

}