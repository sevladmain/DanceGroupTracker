package ua.org.dancegrouptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.org.dancegrouptracker.model.Group;
import ua.org.dancegrouptracker.services.GroupService;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by SeVlad on 08.05.2017.
 */
@Controller
public class GroupController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/admin/add_group", method = RequestMethod.GET)
    public String showAddNewGroupPage(Model model){
        model.addAttribute("newGroup", new Group());
        return "group.add";
    }

    @RequestMapping(value = "/admin/newgroup", method = RequestMethod.POST)
    public String addNewGroup(@Valid @ModelAttribute("newGroup") Group newGroup,
                              BindingResult result,
                              Locale locale, Model model){
        if(result.hasErrors()){
            String message = messageSource.getMessage("GroupController.NewGroupError", null, locale);
            model.addAttribute("error", message);
        } else {
            try {
                groupService.saveOrUpdateGroup(newGroup);
                String message = messageSource.getMessage("GroupController.GroupSuccessfullySaved", null, locale);
                model.addAttribute("msg", message);
            } catch (Exception e){
                String message = messageSource.getMessage("GroupController.CantSaveGroup", null, locale);
                model.addAttribute("error", message);
            }
        }
        return "group.add";
    }
}
