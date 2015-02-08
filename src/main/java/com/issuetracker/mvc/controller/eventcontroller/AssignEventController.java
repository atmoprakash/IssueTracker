package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.service.eventservices.EventService;
import com.issuetracker.mvc.service.issueservice.IssueService;
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
    @Autowired
    IssueService issueService;

    @RequestMapping(value="/assignEvent")
    public String assignIssueUser(@RequestParam Integer user_id,@RequestParam String username,HttpServletRequest request, HttpSession session){
        Integer issue_id=(Integer)session.getAttribute("issue_id");
        session.setAttribute("user_name", username);
       String assignedDate=(String) session.getAttribute("assignedDate");

        session.setAttribute("user_id",user_id);
        eventService.insertData(user_id, issue_id);
      Integer event_id= eventService.getEventId(issue_id);
        issueService.updateStatus(issue_id);
     eventService.insertEventRecord(assignedDate,username,event_id);

        return "redirect:eventHome";
    }



}
