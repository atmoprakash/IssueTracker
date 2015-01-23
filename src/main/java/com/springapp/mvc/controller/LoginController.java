package com.springapp.mvc.controller;

import com.springapp.mvc.database.DatabaseQuery;
import com.springapp.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by acer on 1/21/2015.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("login", "command", new User());
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("username") User user, ModelMap model) throws SQLException, ClassNotFoundException {
        DatabaseQuery q=new DatabaseQuery();
        boolean result = q.databaseQueryLogin(user.getUsername(), user.getPassword());
        if (result == true) {
            return  "welcome";
        } else {
            return  "error";

        }

    }
}

