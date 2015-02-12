package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class DeleteUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String welcome(@RequestParam Integer id, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        userService.deleteData(id);
        return "redirect:/home";
    }

}

