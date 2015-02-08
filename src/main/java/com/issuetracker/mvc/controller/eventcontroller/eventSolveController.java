package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import com.issuetracker.mvc.service.issueservice.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sakshi on 2/2/2015.
 */
@Controller
public class eventSolveController {
    @Autowired
    EventRecordService eventRecordService;
    @Autowired
    IssueService issueService;
    @RequestMapping("/solve")
    public String eventSolve(@RequestParam int event_id ,HttpSession session)
    {
     String name=(String)session.getAttribute("userName");
        User name1= (User) session.getAttribute("result");
       AssignEvent issue_id= eventRecordService.getIssueTrackerId(event_id);
        List<EventRecord> eventRecord=eventRecordService.checkEventId(event_id);
        if(eventRecord.isEmpty()) {
         eventRecordService.insertSelfEventRecord(event_id, name1.getName());
            issueService.updateEventStatusSolved(issue_id.getIssue_tracker_id());
        }
        else {
            eventRecordService.update(event_id, name);
            issueService.updateEventStatusSolved(issue_id.getIssue_tracker_id());
        }
        eventRecordService.makeSolvedOne(event_id);

        return "redirect:/eventHome";

    }
}
