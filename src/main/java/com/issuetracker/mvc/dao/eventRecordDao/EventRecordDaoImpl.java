package com.issuetracker.mvc.dao.eventRecordDao;

import com.issuetracker.mvc.model.AssignEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by acer on 2/2/2015.
 */
public class EventRecordDaoImpl implements EventRecordDao {
    @Autowired
    DataSource dataSource;
    @Override
    public void insert(AssignEvent assignEvent,int id) {
        String sql="insert into event_record(issue_event_id,issue_assigned_from,issue_transfer_to,event_created_date,event_solved_date,remarks)"+ "values(?,?,?,?,?,?)";
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createdTime = sdf.format(dt);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{assignEvent.getIssue_event_id(),assignEvent.getUser_id(),id,createdTime,null,"testing"});
    }
}
