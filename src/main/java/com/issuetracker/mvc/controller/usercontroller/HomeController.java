package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.database.DatabaseQuery;
import com.issuetracker.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        HttpSession session1=request.getSession();
        if(session1.getAttribute("userid")!=null) {
            Integer id= (Integer) session.getAttribute("userid");
            DatabaseQuery q = new DatabaseQuery();
            ArrayList<User> us = q.getAllUser(id);
            model.addAttribute("username", us);
            return "welcome";
        }
        else {

        return "login";
        }
    }
}
