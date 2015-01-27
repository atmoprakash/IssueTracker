package com.issuetracker.mvc.controller;

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
public class UpdateController {
    @RequestMapping(value = "/update", method = RequestMethod.GET)

    public String update(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        int clickednum = Integer.parseInt(request.getParameter("clickup"));
        session.setAttribute("save",clickednum);
        DatabaseQuery q = new DatabaseQuery();
        User updateUser = q.getUpdateInfo(clickednum);
        if (updateUser != null) {
            session.setAttribute("updateUserValue", updateUser);
            return "update";
        }
        return "error";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("username") User user, ModelMap model, HttpServletRequest request, HttpSession session) throws SQLException, ClassNotFoundException {
        DatabaseQuery q=new DatabaseQuery();
        Integer id= (Integer) session.getAttribute("save");
        boolean updateUser = q.updateQueryLogin(id,user.getName(),user.getUsername(), user.getPassword());
        if(updateUser==true){
            return "redirect:home";
        }
        else{
            return "error";
        }

    }


}
