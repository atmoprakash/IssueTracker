package com.issuetracker.mvc.service.eventRecord;

import com.issuetracker.mvc.dao.eventRecordDao.EventRecordDao;
import com.issuetracker.mvc.model.AssignEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by acer on 2/2/2015.
 */
public class EventRecordImpl implements EventRecord {
    @Autowired
    EventRecordDao eventRecordDao;
    @Override
    public void insert(AssignEvent assignEvent ,int id) {
        eventRecordDao.insert(assignEvent,id);
    }
}
