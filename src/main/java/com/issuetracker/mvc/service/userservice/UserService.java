package com.issuetracker.mvc.service.userservice;

import com.issuetracker.mvc.model.User;

import java.util.List;


public interface UserService {

    public void insertData(User user,String name);
    public boolean updateData(User user);
    public void deleteData(Integer id);
    public User checkUser(String u,String p);
    public User getUser(Integer id);
    public List<User> getUserList(Integer id);
    public List<User> getUserActiveList(Integer id);
    public void activeData(Integer id);

}


