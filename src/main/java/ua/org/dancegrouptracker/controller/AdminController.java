package ua.org.dancegrouptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by SeVlad on 28.02.2017.
 */
@Controller
public class AdminController {
    @RequestMapping("/admin")
    public String getAdminPage(Locale locale, Model model){
        return "admin";
    }
}
