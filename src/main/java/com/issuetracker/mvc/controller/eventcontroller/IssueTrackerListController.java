package com.issuetracker.mvc.controller.eventcontroller;

import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sakshi on 2/2/2015.
 */
@Controller
public class IssueTrackerListController {
    @Autowired
    EventRecordService eventRecordService;
    @RequestMapping("/issueTrackList")
    public ModelAndView getIssueTracker()
    {
        List<EventRecord> eventRecords=eventRecordService.getEventRecordList();
        return new ModelAndView("issueTrackList","issueList",eventRecords);
    }
}
