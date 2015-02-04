package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class UpdateUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateGetIssue(@RequestParam Integer id,@ModelAttribute User user){
        user=userService.getUser(id);
       return new ModelAndView("update","updateUserValue",user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateIssue(@ModelAttribute User user){
        userService.updateData(user);
        return "redirect:/home";
}


}
