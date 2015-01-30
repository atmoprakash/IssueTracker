package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class AddUserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("add", "command", new User());
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String insert(@ModelAttribute User user){
        userService.insertData(user);
        return "redirect:/home";
    }


}
