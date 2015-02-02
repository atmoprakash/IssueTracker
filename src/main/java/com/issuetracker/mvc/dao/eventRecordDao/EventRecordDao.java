package com.issuetracker.mvc.dao.eventRecordDao;

import com.issuetracker.mvc.model.EventRecord;

import java.util.List;

/**
 * Created by sakshi on 2/1/2015.
 */
public interface EventRecordDao {
    public void insertEventRecord(int issueId,String username,String name,String assignedDate);
    public void update(int id,String username);
    public List<EventRecord> getEventRecordList();

}
