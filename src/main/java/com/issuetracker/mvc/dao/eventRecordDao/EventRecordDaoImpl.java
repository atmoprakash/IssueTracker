package com.issuetracker.mvc.dao.eventRecordDao;


import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.rowmapper.EventRecordCheckEventIdRowMapper;
import com.issuetracker.mvc.rowmapper.EventRecordRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakshi on 2/1/2015.
 */
public class EventRecordDaoImpl implements EventRecordDao{
    @Autowired
    DataSource dataSource;

    @Override
    public void update(int id, String username) {

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String remark="solved";
        String query="update event_record set event_solve_date='"+currentTime+"',remarks='"+remark+"' where issue_event_id="+id+" AND issue_transfer_to='"+username+"'";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(query);
    }

    @Override
    public void insertEventRecord(int issueId,String username,String name,String assignedDate) {

        String remarks="Transfer";
        String sql="insert into event_record(issue_event_id,issue_assigned_to,issue_transfer_to,event_created_date,remarks)values(?,?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{issueId,username,name,assignedDate,remarks});

    }

    @Override
    public List<EventRecord> getEventRecordList() {
        List eventRecordList=new ArrayList();
        String sql="SELECT t.issuename,t.servicename,r.issue_assigned_to,r.issue_transfer_to,r.event_created_date,r.event_solve_date,r.remarks FROM event_record r,issue_event e,issue_tracker t\n" +
                "WHERE e.issue_event_id=r.issue_event_id  AND e.issue_tracker_id=t.issue_tracker_id";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
       eventRecordList= jdbcTemplate.query(sql,new EventRecordRowMapper());
        return eventRecordList;
    }

    @Override
    public void makeSolvedOne(Integer id) {
        String sql="update  issue_event set solve=1 where issue_event_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public void insertSelfEventRecord(int id, String name) {
        String sql="insert into event_record(issue_event_id,issue_assigned_to,issue_transfer_to,event_created_date,remarks)values(?,?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String SolvedTime = sdf.format(dt);
        String remarks="SelfSolved";
        jdbcTemplate.update(sql,new Object[]{id,name,null,SolvedTime,remarks});
    }

    @Override
    public List<EventRecord> checkEventId(Integer id) {
        List checkEventList=new ArrayList();
        String sql="Select * from event_record where issue_event_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
       checkEventList= jdbcTemplate.query(sql,new EventRecordCheckEventIdRowMapper());
        return checkEventList;
    }

    @Override
    public List<EventRecord> getHistory(Integer id) {
        List seeHistory=new ArrayList();
        String sql="select * from event_record where issue_event_id=" +id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        seeHistory=jdbcTemplate.query(sql,new EventRecordCheckEventIdRowMapper());
        return  seeHistory;
    }
}
