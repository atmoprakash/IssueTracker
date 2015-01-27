package com.issuetracker.mvc.dao;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */

public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(User user) {
        String sql = "Insert into user(id,username,password,created_date,created_by,status) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getId(),user.getUsername(),user.getPassword(),user.getCreated_date(),user.getCreated_by(),user.getStatus()});
    }

    @Override
    public void update(User user) {
        String sql = "update user set username=?,password=?,created_date=? created_by=? where id=?";
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getCreated_date(),user.getCreated_by(),user.getId()});
    }

    @Override
    public void delete(Integer id) {
        String sql = "Delete from user where id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public User getUser(Integer id) {
        String sql = "Select * from person where id=" + id + "";
        List<User> userList = new ArrayList<User>();
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList.get(0);
    }

    @Override
    public List<User> listUsers() {
        List<User> personlist = new ArrayList<User>();
        String sql = "Select * from user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
