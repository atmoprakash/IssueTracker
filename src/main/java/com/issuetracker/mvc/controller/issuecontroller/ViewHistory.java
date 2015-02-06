package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by acer on 2/3/2015.
 */
@Controller
public class ViewHistory {
    @Autowired
    EventRecordService eventRecordService;

    @RequestMapping(value = "/viewHistory")
    public ModelAndView viewHistory(@RequestParam Integer id,Model model) {
        AssignEvent getEventId = eventRecordService.getEventId(id);
        if (getEventId == null) {
            return new ModelAndView("error");
        } else {
            List<EventRecord> seeHistory = eventRecordService.getHistory(getEventId.getIssue_event_id());
            return new ModelAndView("issueTrackList", "issueList", seeHistory);
        }
    }
}
