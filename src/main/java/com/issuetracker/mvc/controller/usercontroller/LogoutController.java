package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by acer on 1/30/2015.
 */
@Controller
public class LogoutController {
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,HttpSession session){
        User us=(User) session.getAttribute("result");
        if(us!=null){
            session.removeAttribute("result");
            return "redirect:login";
        }
        else{
            return "login";
        }
    }

}
