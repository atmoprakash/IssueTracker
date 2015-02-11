package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import com.issuetracker.mvc.service.eventservices.EventService;
import com.issuetracker.mvc.service.issueservice.IssueService;
import com.issuetracker.mvc.service.userservice.UserService;
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
    @Autowired
    UserService userService;
    @Autowired
    EventRecordService eventRecordService;

    @RequestMapping(value="/assignEvent")
    public String assignIssueUser(HttpServletRequest request, HttpSession session,@RequestParam Integer id) {
        Integer issue_id = (Integer) session.getAttribute("issue_id");
        if (id!= null)
        {

            eventService.updateUserId(id, issue_id);

            String username= userService.getUserNamebyId(id);
            Integer event_id= eventService.getEventId(issue_id);
            String assignedDate=  (String ) session.getAttribute("assignedDate");
            eventRecordService.insertEventRecord(username,assignedDate,event_id);

        }

        issueService.updateStatus(issue_id);


        return "redirect:eventHome";
    }



}