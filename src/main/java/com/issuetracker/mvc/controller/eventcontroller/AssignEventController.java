package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.service.eventservices.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by acer on 1/29/2015.
 */
@Controller
public class AssignEventController {
    @Autowired
    EventService eventService;
    @RequestMapping(value="/assignEvent")
    public String assignIssueUser(@RequestParam Integer user_id,HttpServletRequest request, HttpSession session){
        Integer issue_id=(Integer)session.getAttribute("issue_id");
        eventService.insertData(user_id,issue_id);
        return "redirect:home";
    }
}
