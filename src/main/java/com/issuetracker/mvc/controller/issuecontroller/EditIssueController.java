package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.service.issueservice.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acer on 1/27/2015.
 */
@Controller
public class EditIssueController {
    @Autowired
    IssueService issueService;
    @RequestMapping(value = "/editIssue",method = RequestMethod.GET)
    public ModelAndView editIssue(@RequestParam Integer id,@ModelAttribute IssueModel issue){
        issue=issueService.getUser(id);
        return new ModelAndView("editIssue","editIssue",issue);
    }

//    @RequestMapping(value = "/editIssue",method = RequestMethod.POST)
//    public ModelAndView editIssuePost(@RequestParam Integer id,@ModelAttribute IssueModel issue){
//        issue=issueService.getUser(id);
//
//    }
}
