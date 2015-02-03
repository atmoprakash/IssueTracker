package com.issuetracker.mvc.service.eventRecordService;

import com.issuetracker.mvc.model.EventRecord;

import java.util.List;

/**
 * Created by sakshi on 2/1/2015.
 */
public interface EventRecordService {
    public void insertEventRecord(int issueId,String username,String name,String assignedDate);
    public void update(int id,String username);
    public List<EventRecord> getEventRecordList();
    public void makeSolvedOne(Integer id);
    public void insertSelfEventRecord(int id,String name);
}
