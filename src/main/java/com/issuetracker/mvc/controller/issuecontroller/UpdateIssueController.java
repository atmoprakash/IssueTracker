package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by acer on 1/27/2015.
 */
@Controller
public class UpdateIssueController {
    @Autowired
    IssueService issueService;
    @RequestMapping(value = "/updateIssue",method = RequestMethod.POST)
    public String updateIssue(@ModelAttribute IssueModel issue){
        issueService.updateData(issue);
        return "redirect:/getIssueList";
    }
}
