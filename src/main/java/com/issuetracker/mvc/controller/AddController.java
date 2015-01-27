package com.issuetracker.mvc.controller;

import com.issuetracker.mvc.database.DatabaseQuery;
import com.issuetracker.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class AddController {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("add", "command", new User());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        DatabaseQuery q=new DatabaseQuery();
        boolean result = q.addQuery(user.getName(), user.getUsername(), user.getPassword(),user.getStatus());
        if (result == true) {
            return "redirect:home";
        } else {
            return  "login";

        }

    }
}
