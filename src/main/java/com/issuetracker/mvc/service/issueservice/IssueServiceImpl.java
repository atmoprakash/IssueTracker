package com.issuetracker.mvc.service.issueservice;

import com.issuetracker.mvc.dao.issueDao.IssueDao;
import com.issuetracker.mvc.model.IssueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
@Service
@Transactional
public class IssueServiceImpl implements IssueService {

@Autowired
IssueDao issueDao;

    @Override
    public void insertData(IssueModel user) {
        issueDao.insertData(user);
    }

    @Override
    public void updateData(IssueModel user) {
        issueDao.updateData(user);
    }

    @Override
    public void deleteData(Integer id) {
        issueDao.deleteData(id);
    }

    @Override
    public IssueModel getUser(Integer id) {
        return issueDao.getUser(id);
    }

    @Override
    public List<IssueModel> getUserList() {
        return issueDao.getUserList();
    }

    @Override
    public void updateStatus(Integer id) {
        issueDao.updateStatus(id);
    }

    @Override
    public void updateEventStatusSolved(Integer id) {
        issueDao.updateEventStatusSolved(id);
    }
}
