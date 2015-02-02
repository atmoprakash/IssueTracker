package com.issuetracker.mvc.dao.eventDao;


import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.rowmapper.EventRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 1/29/2015.
 */
@Repository
public class EventDaoImpl implements EventDao {
    @Autowired
    DataSource dataSource;

    @Override
    public List<IssueModel> getUserAssignedList(Integer id) {
        List userList=new ArrayList();
        String sql="SELECT t.issuename,t.servicename,t.issuedate,e.assigned_date FROM issue_tracker t,issue_event e\n" +
                "WHERE t.issue_tracker_id=e.issue_tracker_id AND e.user_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new EventRowMapper());
        return userList;

    }

    @Override
    public void insertData(Integer user_id,Integer issue_id ) {
        String sql="Insert into issue_event(user_id,issue_tracker_id,assigned_date,remarks)"+ "values(?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String remarks="solvePblm";
        jdbcTemplate.update(sql,new Object[]{user_id,issue_id,currentTime,remarks});


    }

    @Override
    public void updateTransferData(Integer user_id, Integer event_id) {
        String sql="update issue_event set user_id=? where issue_event_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String updateTime = sdf.format(dt);
        jdbcTemplate.update(sql,new Object[]{user_id,event_id});

    }
}
