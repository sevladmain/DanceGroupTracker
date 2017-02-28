package ua.org.dancegrouptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SeVlad on 28.02.2017.
 */
@Controller
public class AdminController {
    @RequestMapping(name="/admin")
    public String getAdminPage(Model model){
        return "admin";
    }
}
