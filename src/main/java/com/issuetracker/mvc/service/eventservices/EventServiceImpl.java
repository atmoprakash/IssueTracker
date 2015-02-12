package com.issuetracker.mvc.service.eventservices;

import com.issuetracker.mvc.dao.eventDao.EventDao;
import com.issuetracker.mvc.model.IssueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 1/29/2015.
 */

public class EventServiceImpl implements EventService {
    @Autowired
    EventDao eventDao;
    @Override
    public List<IssueModel> getUserAssignedList(Integer id){
        return eventDao.getUserAssignedList(id);
    }

    @Override
    public void updateUserId(Integer user_id, Integer issue_id) {
       eventDao.updateUserId(user_id,issue_id);
    }

    @Override
    public void updateTransferData(Integer user_id, Integer event_id) {
        eventDao.updateTransferData(user_id,event_id);
    }

    @Override
    public int getEventId(int event_id) {
        return eventDao.getEventId(event_id);
    }




}
