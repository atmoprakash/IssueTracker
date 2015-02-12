package com.issuetracker.mvc.service.eventRecordService;

import com.issuetracker.mvc.dao.eventRecordDao.EventRecordDao;
import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sakshi on 2/1/2015.
 */
public class EventRecordServiceImpl implements EventRecordService {
    @Autowired
    EventRecordDao eventRecordDao;

    @Override
    public void insertEventRecord(int issueId,String username, String name,String assignedDate) {
        eventRecordDao.insertEventRecord(issueId,username,name,assignedDate);


    }

    @Override
    public void update(int id, String username,String date) {
        eventRecordDao.update(id,username,date);
    }

    @Override
    public List<EventRecord> getEventRecordList() {
        return eventRecordDao.getEventRecordList();
    }

    @Override
    public void makeSolvedOne(Integer id) {
        eventRecordDao.makeSolvedOne(id);
    }

    @Override
    public void insertSelfEventRecord(int id, String name,String date) {
        eventRecordDao.insertSelfEventRecord(id,name,date);
    }

    @Override
    public List<String> checkEventId(Integer id) {
        return eventRecordDao.checkEventId(id);
    }

    @Override
    public List<EventRecord> getHistory(List<Integer>  id) {
        return eventRecordDao.getHistory(id);
    }

    @Override
    public List<Integer> getEventId(Integer id) {
        return eventRecordDao.getEventId(id);
    }

    @Override
    public AssignEvent getIssueTrackerId(Integer id) {
       return eventRecordDao.getIssueTrackerId(id);
    }

    @Override
    public void insertNewIssue(int event_id) {
        eventRecordDao.insertNewIssue(event_id);
    }
    @Override
    public void insertEventRecord( String user_name,String date,Integer event_id) {
        eventRecordDao.insertEventRecord(user_name,date,event_id);
    }

}
