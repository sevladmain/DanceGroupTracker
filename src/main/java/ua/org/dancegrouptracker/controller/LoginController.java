package ua.org.dancegrouptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.org.dancegrouptracker.exceptions.EmailExistsException;
import ua.org.dancegrouptracker.model.Role;
import ua.org.dancegrouptracker.model.User;
import ua.org.dancegrouptracker.services.RoleService;
import ua.org.dancegrouptracker.services.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Locale;

import static ua.org.dancegrouptracker.model.RoleType.ROLE_USER;

/**
 * Created by SeVlad on 28.02.2017.
 */
@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    @RequestMapping(value="/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Locale locale,
                        Model model){
        if(error != null){
            String message = messageSource.getMessage("LoginController.WrongEmailOrPassword", null, locale);
            model.addAttribute("error", message);
        }
        if(logout != null){
            String message = messageSource.getMessage("LoginController.SuccessfullyLogout", null, locale);
            model.addAttribute("msg", message);
        }
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("isRegister", false);
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("isRegister", true);
            return "login";
        }

        Role role = roleService.getRolesByName(ROLE_USER.name());
        user.setAuthority(role);
        user.setEnabled(true);
        user.setDateRegister(LocalDate.now());

        if(userService.getUserByUsername(user.getUsername()) != null){
            result.rejectValue("username", "DuplicateKey.user.username");
            model.addAttribute("isRegister", true);
            return "login";
        }
        if(createUserAccount(user) ==  null){
            result.rejectValue("email", "DuplicateKey.user.email");
            model.addAttribute("isRegister", true);
            return "login";
        }
        return "home";
    }

    private String createUserAccount(User user) {
        String username = null;
        try {
            username = userService.saveOrUpdateUser(user);
        } catch(EmailExistsException e){
            return null;
        }
        return username;
    }
}
