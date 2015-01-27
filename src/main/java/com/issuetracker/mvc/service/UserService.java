package com.issuetracker.mvc.service;

import com.issuetracker.mvc.model.User;

import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
public interface UserService {

    public void create(User user);

    public void update(User user);

    public User getUser(Integer id);

    public List<User> listUsers();

    public void delete(Integer id);
}
