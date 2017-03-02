package ua.org.dancegrouptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

/**
 * Created by SeVlad on 28.02.2017.
 */
@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Locale locale,
                        Model model){
        if(error == null){
            String message = messageSource.getMessage("LogginController.WrongEmailOrPassword", null, locale);
            model.addAttribute("error", message);
        }
        if(logout != null){
            String message = messageSource.getMessage("LogginController.SuccessfullyLogout", null, locale);
            model.addAttribute("msg", message);
        }
        return "login";
    }
}
