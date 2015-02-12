package com.issuetracker.mvc.service.eventservices;


import com.issuetracker.mvc.model.IssueModel;

import java.util.List;

/**
 * Created by acer on 1/29/2015.
 */

public interface EventService {
    public List<IssueModel> getUserAssignedList(Integer id);
    public void updateUserId(Integer user_id,Integer issue_id);
    public void updateTransferData(Integer user_id,Integer event_id);
    public int getEventId(int event_id);

}
