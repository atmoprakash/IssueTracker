package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by acer on 1/21/2015.
 */
@Controller
public class LoginHomeController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        {
            User result=userService.checkUser(user.getUsername(),user.getPassword());
            if((result!=null) && (result.getRole().equals("ADMIN")) && (result.getStatus().equals("ACTIVE"))){
                session.setAttribute("result",result);
                String userName=  result.getName();
                session.setAttribute("userName",userName);

            return "redirect:/adminHome";
        }
           else if((result!=null) && (result.getRole().equals("USER")) && (result.getStatus().equals("ACTIVE"))) {
                session.setAttribute("result", result);
                String userName = result.getName();
                session.setAttribute("userName", userName);

                return "redirect:/eventHome";
            }
            else if ((result!=null)  && (result.getStatus().equals("INACTIVE"))){
                String info1="deactivated";
                model.addAttribute("info1",info1);
                return "login";
            }
            else {
                return "redirect:login";
            }
        }
//        session = request.getSession();
//        DatabaseQuery q=new DatabaseQuery();
//        Integer mainUserid = q.QueryLogin(user.getUsername(), user.getPassword());
//
//        if (mainUserid!=null) {
//            session.setAttribute("userid",mainUserid);
//            return "redirect:home";
//
//        } else {
//            return "login";
//
//        }

    }
}

