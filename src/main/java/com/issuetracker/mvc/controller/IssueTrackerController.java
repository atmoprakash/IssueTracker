package com.issuetracker.mvc.controller;

import com.issuetracker.mvc.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by acer on 1/25/2015.
 */
public class IssueTrackerController {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Model model){
        model.addAttribute("user" ,new User());
        return "addperson";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user,
                       BindingResult br, Model model) {
//        if (br.hasErrors()) {
//            return "addperson";
//        }
//        if (user.getId() != null) {
//            update(user);
//        } else {
//            service.create(user);
//        }
        return "redirect:list";
    }

}

