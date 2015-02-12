package com.issuetracker.mvc.dao.eventDao;

import com.issuetracker.mvc.model.IssueModel;

import java.util.List;

/**
 * Created by acer on 2/2/2015.
 */

    public interface EventDao {
        public List<IssueModel> getUserAssignedList(Integer id);
        public void updateUserId(Integer user_id,Integer issue_id);
        public void updateTransferData(Integer user_id,Integer event_id);
    public Integer getEventId(int event_id);
    public void insertEventRecord(String date,String user_name,Integer event_id);



    }

