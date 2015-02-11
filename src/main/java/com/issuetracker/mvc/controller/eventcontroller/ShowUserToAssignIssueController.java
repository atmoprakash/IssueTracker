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
 * Created by acer on 1/29/2015.
 */
@Controller
public class ShowUserToAssignIssueController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/showUserToAssignIssue",method = RequestMethod.GET)
    public ModelAndView showUserToAssignIssue(@RequestParam Integer issue_tracker_id, HttpServletRequest request, HttpSession session){
        session.setAttribute("issue_id",issue_tracker_id);
        User us=(User)session.getAttribute("result");
        List<User> userList = userService.getUserActiveList(us.getUser_id());
        return new ModelAndView("showUserToAssignIssue", "userList", userList);

    }

}
