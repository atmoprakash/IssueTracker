package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.service.eventRecord.EventRecord;
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
public class TransferUserIssue {
    @Autowired
    EventService eventService;
    @Autowired
    EventRecord eventRecord;
    @RequestMapping(value = "/transferUserIssue")
    public String transferUser(@RequestParam Integer user_id,HttpServletRequest request,HttpSession session){
        Integer event_id=(Integer)session.getAttribute("event_id");
       AssignEvent assignEvent= (AssignEvent) eventService.getAllInfo();
        eventRecord.insert(assignEvent,user_id);
        eventService.updateTransferData(user_id, event_id);
        return "redirect:eventHome";
    }
}
