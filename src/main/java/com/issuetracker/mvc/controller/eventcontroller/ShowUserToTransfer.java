package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView showUserToAssignIssue(@RequestParam Integer event_id,@RequestParam String issue_date, HttpServletRequest request, HttpSession session,Model model){
        session.setAttribute("event_id",event_id);
        //session.setAttribute("assignedDate",assigned_date);
        model.addAttribute("asignDate",issue_date);
        User us=(User) session.getAttribute("result");
        List<User> userList = userService.getUserList(us.getUser_id());
        return new ModelAndView("showUserToTransferIssue", "userList", userList);

    }
}
