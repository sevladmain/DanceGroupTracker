package ua.org.dancegrouptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.org.dancegrouptracker.services.GroupService;

/**
 * Created by SeVlad on 08.05.2017.
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/add_group", method = RequestMethod.GET)
    String showAddNewGroupPage(Model model){
        return "group.add";
    }
}
