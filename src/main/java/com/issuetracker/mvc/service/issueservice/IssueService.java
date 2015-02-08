package com.issuetracker.mvc.service.issueservice;

import com.issuetracker.mvc.model.IssueModel;

import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
public interface IssueService {

    public void insertData(IssueModel user);
    public void updateData(IssueModel user);
    public void deleteData(Integer id);
    public IssueModel getUser(Integer id);
    public List<IssueModel> getUserList();
    public void updateStatus(Integer id);
    public void updateEventStatusSolved(Integer id);




}
