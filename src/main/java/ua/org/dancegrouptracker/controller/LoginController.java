package ua.org.dancegrouptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by SeVlad on 28.02.2017.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Model model){
        if(error == null){
            model.addAttribute("error", "Невірне ім'я користувача або пароль");
        }
        if(logout != null){
            model.addAttribute("msg", "Ви успішно вийшли з системи");
        }
        return "login";
    }
}
