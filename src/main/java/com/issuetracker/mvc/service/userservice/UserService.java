package com.issuetracker.mvc.service.userservice;

import com.issuetracker.mvc.model.User;

import java.util.List;

/**
 * Created by acer on 1/28/2015.
 */
public interface UserService {

    public void insertData(User user);
    public void updateData(User user);
    public void deleteData(Integer id);
    public User checkUser(String u,String p);
    public User getUser(Integer id);
    public List<User> getUserList();
    public List<User> getUserActiveList();
    public void activeData(Integer id);

}


