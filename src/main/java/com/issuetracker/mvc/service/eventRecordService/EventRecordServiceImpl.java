package com.issuetracker.mvc.service.eventRecordService;

import com.issuetracker.mvc.dao.eventRecordDao.EventRecordDao;
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
    public void update(int id, String username) {
        eventRecordDao.update(id,username);
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
    public void insertSelfEventRecord(int id, String name) {
        eventRecordDao.insertSelfEventRecord(id,name);
    }

    @Override
    public List<EventRecord> checkEventId(Integer id) {
        return eventRecordDao.checkEventId(id);
    }

    @Override
    public List<EventRecord> getHistory(Integer id) {
        return eventRecordDao.getHistory(id);
    }
}
