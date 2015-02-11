package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.EventRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sakshi on 2/2/2015.
 */
public class EventRecordRowMapper implements RowMapper<EventRecord> {
    public EventRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        EventRecord eventRecord=new EventRecord();

        eventRecord.setIssuename(rs.getString("issuename"));
        eventRecord.setServicename(rs.getString("servicename"));
        eventRecord.setIssue_assigned_to(rs.getString("issue_assigned_to"));
        eventRecord.setIssue_transfer_to(rs.getString("issue_transfer_to"));
        eventRecord.setEvent_created_date(rs.getString("event_created_date"));
        eventRecord.setEvent_transfered_date(rs.getDate("event_transfered_date"));
        eventRecord.setEvent_action_date(rs.getString("event_action_date"));
        eventRecord.setRemarks(rs.getString("remarks"));
       // eventRecord.setIssue_event_id(rs.getInt("issue_event_id"));
      //  eventRecord.setIssue_tracker_id(rs.getInt("issue_tracker_id"));
        return eventRecord;
    }

}
