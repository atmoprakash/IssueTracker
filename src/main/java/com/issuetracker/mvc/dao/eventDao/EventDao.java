package com.issuetracker.mvc.dao.eventDao;


import com.issuetracker.mvc.model.IssueModel;

import java.util.List;

/**
 * Created by acer on 1/29/2015.
 */
public interface EventDao {
    public List<IssueModel> getUserAssignedList(Integer id);
    public void insertData(Integer user_id,Integer issue_id);
    public void updateTransferData(Integer user_id,Integer event_id);
}
