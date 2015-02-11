package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.service.eventservices.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by acer on 2/10/2015.
 */
@Controller
public class AdminUserControl {
    @Autowired
    EventService eventService;
  @RequestMapping(value = "/adminUserControl" ,method = RequestMethod.GET)
    public ModelAndView admin(@RequestParam Integer id){
      List<IssueModel> assignedEvent=eventService.getUserAssignedList(id);
      return new ModelAndView("eventAssignList", "assigndetail", assignedEvent);
  }
}
