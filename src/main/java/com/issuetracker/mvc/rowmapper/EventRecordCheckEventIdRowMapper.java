package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.EventRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by acer on 2/3/2015.
 */
public class EventRecordCheckEventIdRowMapper  implements RowMapper<EventRecord> {
    public EventRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        EventRecord eventRecord=new EventRecord();

        eventRecord.setEvent_record_id(rs.getInt(1));
        eventRecord.setIssue_event_id(rs.getInt(2));
        eventRecord.setIssue_assigned_to(rs.getString(3));
        eventRecord.setIssue_transfer_to(rs.getString(4));
        eventRecord.setEvent_created_date(rs.getString(5));
        eventRecord.setEvent_transfered_date(rs.getDate(6));
        eventRecord.setEvent_action_date(rs.getString(7));
        eventRecord.setRemarks(rs.getString(8));
        return eventRecord;
    }
}
