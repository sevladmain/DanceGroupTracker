package ua.org.dancegrouptracker.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.org.dancegrouptracker.model.User;

import static org.hamcrest.core.Is.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by SeVlad on 18.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityAccessTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

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