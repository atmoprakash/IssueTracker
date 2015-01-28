package com.issuetracker.mvc.controller.usercontroller;

import com.issuetracker.mvc.database.DatabaseQuery;
import com.issuetracker.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by acer on 1/26/2015.
 */
@Controller
public class DeleteController {
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String welcome(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        int clickednum=Integer.parseInt(request.getParameter("clickde"));
        DatabaseQuery q=new DatabaseQuery();
       boolean result= q.deleteQuery(clickednum);
        if(result==true){
            return "redirect:home";
        }
        else{
            return "error";
        }
    }
}
