package com.issuetracker.mvc.controller.issuecontroller;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by acer on 1/27/2015.
 */
@Controller
public class IssueHomeConroller {

    @Autowired
    IssueService issueService;

    @RequestMapping(value = "/registerIssue" ,method = RequestMethod.GET)
    public String registerUser(){
        return "registerIssue";
    }

    @RequestMapping("/getIssueList")
    public ModelAndView getUserList(){
        List<IssueModel> issueList= issueService.getUserList();
        return new ModelAndView("issuelist","issueList",issueList);
    }

    @RequestMapping(value = "/insertIssue",method = RequestMethod.POST)
    public String insert(@ModelAttribute IssueModel user){
        issueService.insertData(user);
        return "redirect:/getIssueList";
    }

}
