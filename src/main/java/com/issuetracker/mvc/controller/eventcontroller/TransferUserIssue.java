package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import com.issuetracker.mvc.service.eventservices.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by acer on 1/29/2015.
 */
@Controller
public class TransferUserIssue {
    @Autowired
    EventService eventService;
    @Autowired
    EventRecordService eventRecordService;
    @RequestMapping(value = "/transferUserIssue")
    public String transferUser(@RequestParam Integer user_id,@RequestParam String name,@RequestParam String date,HttpServletRequest request,HttpSession session){
        Integer event_id=(Integer)session.getAttribute("event_id");
        String userName=(String)session.getAttribute("userName");
       // Date date=(Date)session.getAttribute("assignedDate");
        session.setAttribute("username",name);
        eventRecordService.insertEventRecord(event_id, userName, name,date);
        eventService.updateTransferData(user_id, event_id);
        return "redirect:home";
    }
//    @RequestMapping("/solve")
//    public String solveIssue(@RequestParam Integer event_id)
//    {
//        eventRecordService
//    }

}
