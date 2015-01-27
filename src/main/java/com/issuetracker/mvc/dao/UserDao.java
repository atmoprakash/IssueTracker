package com.issuetracker.mvc.dao;

import com.issuetracker.mvc.model.User;

import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
public interface UserDao {
    public void create(User user);
    public void update(User user);
    public void delete(Integer id);
    public User getUser(Integer id);
    public List<User> listUsers();


}
