package com.issuetracker.mvc.service.userservice;

import com.issuetracker.mvc.dao.userDao.UserDao;
import com.issuetracker.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by acer on 1/28/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public void insertData(User user) {
        userDao.insertData(user);
    }

    @Override
    public void updateData(User user) {
        userDao.updateData(user);
    }

    @Override
    public void deleteData(Integer id) {
        userDao.deleteData(id);
    }

    @Override
    public User checkUser(String u,String p) {
        return userDao.checkUser(u,p);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }



    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }


}
