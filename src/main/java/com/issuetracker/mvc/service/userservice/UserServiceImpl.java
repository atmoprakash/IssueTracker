package com.issuetracker.mvc.service.userservice;

import com.issuetracker.mvc.dao.userDao.UserDao;
import com.issuetracker.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public void insertData(User user,String name) {
        userDao.insertData(user,name);
    }

    @Override
    public boolean updateData(User user) {
       return userDao.updateData(user);
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
    public List<User> getUserList(Integer id) {
        return userDao.getUserList(id);
    }

    @Override
    public List<User> getUserActiveList(Integer id)
    {
        return userDao.getUserActiveList(id);
    }

    @Override
    public void activeData(Integer id) {
        userDao.activeData(id);
    }

    @Override
    public String getUserNamebyId(Integer id) {
        return userDao.getUserNamebyId(id);
    }


}
