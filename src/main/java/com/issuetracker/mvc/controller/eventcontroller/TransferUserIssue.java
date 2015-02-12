package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import com.issuetracker.mvc.service.eventservices.EventService;
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
public class TransferUserIssue {
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    EventRecordService eventRecordService;
    @RequestMapping(value = "/transferUserIssue")
    public String transferUser(@RequestParam Integer id,HttpServletRequest request,HttpSession session){
        Integer event_id=(Integer)session.getAttribute("event_id");
        String userName=(String)session.getAttribute("userName");
     String date=(String)session.getAttribute("assignedDate");
        if(id!=null){
            String name= userService.getUserNamebyId(id);
            eventRecordService.insertEventRecord(event_id, userName,name,date);
            eventService.updateTransferData(id, event_id);
        }
       // session.setAttribute("username",name);


        return "redirect:eventHome";
    }


}
