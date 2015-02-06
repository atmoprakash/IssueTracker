package com.issuetracker.mvc.dao.userDao;

import com.issuetracker.mvc.model.User;
import com.issuetracker.mvc.model.UserStatus;
import com.issuetracker.mvc.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 1/28/2015.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    DataSource dataSource;

    @Override
    public void insertData(User user) {
        String sql="Insert into user(name,username,password,created_date,created_by,status)"+ "values(?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String created_by="rewat";
        jdbcTemplate.update(sql,new Object[]{user.getName(),user.getUsername(),user.getPassword(),currentTime,created_by,UserStatus.ACTIVE.toString()});

    }

    @Override
    public void updateData(User user) {
        String sql="update user set name=?,username=?,password=?,created_date=? where user_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = sdf.format(dt);
        jdbcTemplate.update(sql,new Object[]{user.getName(),user.getUsername(),user.getPassword(),updateTime,user.user_id});

    }

    @Override
    public void deleteData(Integer id) {
        String sql = "UPDATE user set status='"+UserStatus.INACTIVE+"' WHERE user_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public User checkUser(String u ,String p) {
        List<User> userList=new ArrayList<User>();
        String sql = "select * from user where username=? and password=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new Object[]{u,p},new UserRowMapper());
        if(!userList.isEmpty()) {
            return userList.get(0);
        }else{
            return  null;
        }

    }

    @Override
    public User getUser(Integer id) {
        List<User> userList=new ArrayList<User>();
        String sql="select * from user where user_id=" +id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new UserRowMapper());
        return userList.get(0);
    }

    @Override
    public List<User> getUserList() {
        List userList=new ArrayList();
        String sql="select * from USER";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new UserRowMapper());
        return userList;
    }

    @Override
    public List<User> getUserActiveList() {
        String status=UserStatus.ACTIVE.toString();
        List userList=new ArrayList();
        String sql="select * from USER where status='"+status+"'";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new UserRowMapper());
        return userList;
    }

    @Override
    public void activeData(Integer id) {
        String sql = "UPDATE user set status='"+UserStatus.ACTIVE+"' WHERE user_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }
}
