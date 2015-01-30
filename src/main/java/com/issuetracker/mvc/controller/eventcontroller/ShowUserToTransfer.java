package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by acer on 1/30/2015.
 */
@Controller
public class ShowUserToTransfer {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/showUserToTransferIssue",method = RequestMethod.GET)
    public ModelAndView showUserToAssignIssue(@RequestParam Integer event_id, HttpServletRequest request, HttpSession session){
        session.setAttribute("event_id",event_id);
        List<User> userList = userService.getUserList();
        return new ModelAndView("showUserToTransferIssue", "userList", userList);

    }
}
