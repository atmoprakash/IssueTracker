package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.service.eventRecordService.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView viewHistory(@RequestParam Integer id) {
        List<EventRecord> seeHistory = eventRecordService.getHistory(id);
        return new ModelAndView("issueTrackList", "issueList", seeHistory);
    }
}
