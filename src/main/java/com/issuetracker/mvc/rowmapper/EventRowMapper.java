package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.IssueModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 1/28/2015.
 */
public class EventRowMapper implements RowMapper<IssueModel> {
    public IssueModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        IssueModel issueModel=new IssueModel();
        issueModel.setIssuename(rs.getString("issuename"));
        issueModel.setServicename(rs.getString("servicename"));
        issueModel.setIssuedate(rs.getString("issuedate"));
        issueModel.setAssigned_date(rs.getString("assigned_date"));
        issueModel.setIssue_event_id(rs.getInt("issue_event_id"));
        return issueModel;
    }
}
