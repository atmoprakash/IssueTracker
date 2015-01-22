package com.springapp.mvc.controller;

import com.springapp.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acer on 1/21/2015.
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public ModelAndView user(){
        return new ModelAndView("hello","command",new Student());
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("username") Student user, ModelMap model) {


        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        if (user.getUsername().equals("admin") && user.getPassword().equals("asif")) {
            return "welcome";
        }
        else {
            return "error";
        }
    }
}

//	Database d= new Database();
//		boolean result = d.DbConnection(username.getUsername(),username.getPassword());
//		if (result==true)
//		{
//			return "welcome";
//		}
//		else
//		{
//			return "error";

//}

