package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
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
    @RequestMapping("/solve")
    public String eventSolve(@RequestParam int event_id ,HttpSession session)
    {
     String name=(String)session.getAttribute("userName");
        User name1= (User) session.getAttribute("result");
        List<EventRecord> eventRecord=eventRecordService.checkEventId(event_id);
        if(eventRecord.isEmpty()) {
            eventRecordService.insertSelfEventRecord(event_id, name1.getName());

        }
        else {
            eventRecordService.update(event_id, name);
        }
        eventRecordService.makeSolvedOne(event_id);

        return "redirect:/eventHome";

    }
}
