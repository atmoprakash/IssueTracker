package com.issuetracker.mvc.service.eventservices;

import com.issuetracker.mvc.model.AssignEvent;

import java.util.List;

/**
 * Created by acer on 1/29/2015.
 */

public interface EventService {
    public List<AssignEvent> getUserAssignedList(Integer id);
    public void insertData(Integer user_id,Integer issue_id);
    public void updateTransferData(Integer user_id,Integer event_id);
}
