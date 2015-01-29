package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.service.issueservice.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by acer on 1/27/2015.
 */
@Controller
public class UpdateIssueController {
//    @Autowired
//    IssueService issueService;
    private IssueService issueService;
    public UpdateIssueController(IssueService issueService){
        this.issueService=issueService;
    }
    @RequestMapping(value = "/updateIssue",method = RequestMethod.POST)
    public String updateIssue(@ModelAttribute IssueModel issue){
        issueService.updateData(issue);
        return "redirect:/getIssueList";
    }
}
