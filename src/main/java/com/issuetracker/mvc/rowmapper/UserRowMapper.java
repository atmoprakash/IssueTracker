package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.IssueModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 1/25/2015.
 */
public class UserRowMapper implements RowMapper<IssueModel> {

    public IssueModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        IssueModel user= new IssueModel();
        user.setId(rs.getInt(1));
        user.setIssuename(rs.getString(2));
        user.setServicename(rs.getString(3));
        user.setIssuedate(rs.getString(4));
        user.setCustomername(rs.getString(5));
        user.setCreatedby(rs.getString(6));
        return user;
    }

}
