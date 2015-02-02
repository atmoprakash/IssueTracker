//package com.issuetracker.mvc.controller.eventRecordController;
//
//import com.issuetracker.mvc.model.AssignEvent;
//import com.issuetracker.mvc.service.eventRecord.EventRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.sql.SQLException;
//
///**
// * Created by acer on 2/2/2015.
// */
//@Controller
//public class EventRecordHome {
//   @Autowired
//    EventRecord eventRecord;
//    @RequestMapping(value = "/createEvent")
//    public ModelAndView all( HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
//    if((session.getAttribute("result")!=null){
//
//        eventRecord.insert(assignEvent);
//}
//    }
//}
