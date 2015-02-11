package com.issuetracker.mvc.dao.eventRecordDao;


import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventRecord;
import com.issuetracker.mvc.model.EventStatus;
import com.issuetracker.mvc.rowmapper.EventHistoryMapper;
import com.issuetracker.mvc.rowmapper.EventRecordCheckEventIdRowMapper;
import com.issuetracker.mvc.rowmapper.EventRecordRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakshi on 2/1/2015.
 */
public class EventRecordDaoImpl implements EventRecordDao {
    @Autowired
    DataSource dataSource;

    @Override
    public void update(int id, String username,String date) {

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        //String query = "insert into  event_record set event_action_date='" + currentTime + "',remarks='" + remark + "' where issue_event_id=" + id + " AND issue_transfer_to='" + username + "'";
        String sql = "insert into event_record(issue_event_id,issue_assigned_to,issue_transfer_to,event_created_date,event_action_date,remarks)values(?,?,?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{id,username,null,date,currentTime,EventStatus.SOLVED.toString()});

    }

    @Override
    public void insertEventRecord(int issueId, String username, String name, String assignedDate) {


        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String sql = "insert into event_record(issue_event_id,issue_assigned_to,issue_transfer_to,event_created_date,event_action_date,remarks)values(?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{issueId, username, name, assignedDate,currentTime,EventStatus.TRANSFER.toString()});

    }

    @Override
    public List<EventRecord> getEventRecordList() {
        List eventRecordList = new ArrayList();
        String sql = "SELECT t.issuename,t.servicename,r.issue_assigned_to,r.issue_transfer_to,r.event_created_date,r.event_action_date,r.remarks FROM event_record r,issue_event e,issue_tracker t\n" +
                "WHERE e.issue_event_id=r.issue_event_id  AND e.issue_tracker_id=t.issue_tracker_id";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        eventRecordList = jdbcTemplate.query(sql, new EventRecordRowMapper());
        return eventRecordList;
    }

    @Override
    public void makeSolvedOne(Integer id) {
        String sql = "update  issue_event set solve=1 where issue_event_id=" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public void insertSelfEventRecord(int id, String name,String date) {
        String sql = "insert into event_record(issue_event_id,issue_assigned_to,issue_transfer_to,event_created_date,event_action_date,remarks)values(?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String SolvedTime = sdf.format(dt);
        jdbcTemplate.update(sql, new Object[]{id, name, null, date,SolvedTime,EventStatus.SELFSOLVED.toString()});
    }

    @Override
    public List<String> checkEventId(Integer id) {
        // List checkEventList = new ArrayList();
        String sql = "Select remarks from event_record where issue_event_id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> remarks=  jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
        return remarks;
    }

    @Override
    public List<EventRecord> getHistory(List<Integer> id) {
        List seeHistory = new ArrayList();
        // List<EventRecord> eventRecords=new ArrayList<EventRecord>();
        //  List eventrocord=new ArrayList();
        for(int i=0;i<id.size();i++){
            String sql = "SELECT t.issuename,t.servicename,r.issue_assigned_to,r.issue_transfer_to,r.event_created_date,r.event_action_date,r.remarks FROM event_record r,issue_event e,issue_tracker t\n" +
                    "WHERE e.issue_event_id=r.issue_event_id  AND e.issue_tracker_id=t.issue_tracker_id and r.issue_event_id="+id.get(i);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            seeHistory = jdbcTemplate.query(sql, new EventRecordRowMapper());

        }

        return seeHistory;
    }

    @Override
    public List<Integer> getEventId(Integer id) {
        // List<AssignEvent> getEventDetail=new ArrayList<AssignEvent>();

        String sql = "SELECT issue_event_id FROM issue_event WHERE issue_tracker_id=" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Integer> eventId= jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(1);
            }
        });

//        if(!getEventDetail.isEmpty()) {
//            return getEventDetail.get(0);
//        }else{
//            return  null;
//        }
        return eventId;
    }

    @Override
    public AssignEvent getIssueTrackerId(Integer id) {
        String sql="select issue_tracker_id from issue_event where issue_event_id=:event_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
        SqlParameterSource sqlParameterSource=new MapSqlParameterSource("event_id",id);
        return  namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, BeanPropertyRowMapper.newInstance(AssignEvent.class));


    }

    @Override
    public void insertNewIssue(int event_id) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String SolvedTime = sdf.format(dt);
        String query="insert into event_record(issue_event_id,event_created_date,remarks)values(?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(query,new Object[]{event_id,SolvedTime, EventStatus.CREATED.toString()});
    }

    @Override
    public void insertEventRecord(String user_name,String date,Integer event_id){
        String query="insert into event_record(issue_event_id,issue_assigned_to,event_created_date,remarks)values(?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(query,new Object[]{event_id,user_name,date,EventStatus.ASSIGNED.toString()});
    }


}