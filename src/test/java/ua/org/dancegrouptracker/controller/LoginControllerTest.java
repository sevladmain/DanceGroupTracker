package ua.org.dancegrouptracker.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.services.RoleService;
import ua.org.dancegrouptracker.services.UserService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by SeVlad on 19.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private MessageSource messageSource;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private LoginController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver)
                .build();

        when(messageSource.getMessage(anyObject(), anyObject(), anyObject())).thenReturn("any string");
    }

    @Test
    public void whenLoginPageThenEmptyUser() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", is(new User())))
                .andExpect(model().attribute("isRegister",is(false)));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void whenUserLogoutThenShouldBeAMessage() throws Exception{
        mockMvc.perform(get("/login").param("logout", "logout"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("msg"))
                .andExpect(model().attributeDoesNotExist("error"))
                .andExpect(view().name("login"));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void whenUserErrorThenShouldBeAMessage() throws Exception{
        mockMvc.perform(get("/login").param("error", "error"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("error"))
                .andExpect(model().attributeDoesNotExist("logout"))
                .andExpect(view().name("login"));
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void whenIncorrectUserThenDoNotRegister() throws Exception{
        User user = new User();
        user.setUsername("sa");
        user.setPassword("sa");
        user.setEmail("1@");
        BindingResult mockBindingResult = mock(BindingResult.class);
        when(mockBindingResult.hasErrors()).thenReturn(true);
        Model mockModel = mock(Model.class);
        String result = controller.registerUser(user, mockBindingResult, mockModel);
        assertThat(result, is(equalTo("login")));
        verifyNoMoreInteractions(userService);
    }
}
