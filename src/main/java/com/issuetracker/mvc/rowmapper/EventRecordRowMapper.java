package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.AssignEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 2/2/2015.
 */
public class EventRecordRowMapper implements RowMapper<AssignEvent> {
        public AssignEvent mapRow(ResultSet rs,int rowNum) throws SQLException{
            AssignEvent assignEvent=new AssignEvent();
            assignEvent.setIssue_event_id(rs.getInt(1));
            assignEvent.setUser_id(rs.getInt(2));
            assignEvent.setIssue_tracker_id(rs.getInt(3));
            assignEvent.setAssigned_date(rs.getString(4));
            assignEvent.setRemarks(rs.getString(5));
            return assignEvent;
        }
}
