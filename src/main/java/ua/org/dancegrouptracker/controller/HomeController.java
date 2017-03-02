package ua.org.dancegrouptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by SeVlad on 11.02.2017.
 * It is home controller
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Locale locale, Model model){
        return "home";
    }
}
