package ua.org.dancegrouptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SeVlad on 11.02.2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "String";
    }
}
