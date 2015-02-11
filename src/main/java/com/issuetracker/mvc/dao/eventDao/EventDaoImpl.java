package com.issuetracker.mvc.dao.eventDao;


import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.rowmapper.EventIdRowMapper;
import com.issuetracker.mvc.rowmapper.EventRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
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
        String sql="SELECT t.issuename,t.servicename,t.issuedate,e.assigned_date,e.issue_event_id FROM issue_tracker t,issue_event e\n" +
                "WHERE t.issue_tracker_id=e.issue_tracker_id AND e.user_id='"+id+"' AND e.solve=0";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new EventRowMapper());
        return userList;

    }

    @Override
    public void updateUserId(final Integer user_id, final Integer issue_id ) {

         final String sql="update issue_event set user_id=? where issue_tracker_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

      jdbcTemplate.update(sql,new Object[]{user_id,issue_id});

        }

    @Override
    public void updateTransferData(Integer user_id, Integer event_id) {
        String sql="update issue_event set user_id=? where issue_event_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{user_id,event_id});

    }

    @Override
    public Integer getEventId(int event_id) {


        String query="select issue_event_id from issue_event where issue_tracker_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
       //return jdbcTemplate.query(query,new EventIdRowMapper()).get(0).getIssue_event_id();
       Integer id=(Integer) jdbcTemplate.queryForObject(query, new Object[]{event_id}, Integer.class);
        return id;
    }

    @Override
    public void insertEventRecord(String date, String user_name, Integer event_id) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        final String query="insert into event_record(issue_event_id,issue_assigned_to,event_created_date,remarks)values(?,?,?,?)";
        String remarks="Assigned";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

       jdbcTemplate.update(query, new Object[]{event_id, user_name, date, remarks});


    }
}