package com.issuetracker.mvc.dao.eventRecordDao;

import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventRecord;

import java.util.List;

public interface EventRecordDao {
    public void insertEventRecord(int issueId,String username,String name,String assignedDate);
    public void update(int id,String username, String date);
    public List<EventRecord> getEventRecordList();
    public void makeSolvedOne(Integer id);
    public void insertSelfEventRecord(int id,String name,String date);
    public List<String> checkEventId(Integer id);
    public List<EventRecord> getHistory(List<Integer> id);
    public List<Integer> getEventId(Integer id);
    public AssignEvent getIssueTrackerId(Integer id);
    public void insertNewIssue(int event_id);
    public void insertEventRecord(String user_name,String date,Integer event_id);

}
