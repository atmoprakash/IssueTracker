package com.issuetracker.mvc.service;

import com.issuetracker.mvc.dao.UserDao;
import com.issuetracker.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public void create(User user) {
    userDao.create(user);
    }

    @Override
    public void update(User user) {
    userDao.update(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
