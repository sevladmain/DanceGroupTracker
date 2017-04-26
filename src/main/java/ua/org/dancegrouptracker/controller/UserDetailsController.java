package ua.org.dancegrouptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.org.dancegrouptracker.model.UserDetails;
import ua.org.dancegrouptracker.services.UserDetailsService;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by SeVlad on 26.04.2017.
 */
@Controller
public class UserDetailsController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/userdetails", method = RequestMethod.GET)
    public String getUserDetailsPage(Model model){
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        UserDetails userDetails = userDetailsService.getUserDetailsByUsername(username);
        if (userDetails == null){
            userDetails = new UserDetails();
            userDetails.setUsername(username);
        }
        model.addAttribute("userdetails", userDetails);
        return "userdetails";
    }

    @RequestMapping(value = "/updatedetails", method = RequestMethod.POST)
    public String updateUserDetails(@Valid @ModelAttribute("userdetails") UserDetails userDetails,
                                    BindingResult result, Locale locale, Model model){
        //TODO: Fix Wrong user details Error - maybe should be username field
        if(result.hasErrors()){
            String message = messageSource.getMessage("UserDetailsController.WrongUserDetails", null, locale);
            model.addAttribute("error", message);
        } else {
            try {
                userDetailsService.saveOrUpdateUserDetails(userDetails);
                String message = messageSource.getMessage("UserDetailsController.UserDetailsSuccessfullySaved", null, locale);
                model.addAttribute("msg", message);
            } catch (Exception e){
                String message = messageSource.getMessage("UserDetailsController.CantSaveUserDetails", null, locale);
                model.addAttribute("error", message);
            }
        }
        return "userdetails";
    }

}
