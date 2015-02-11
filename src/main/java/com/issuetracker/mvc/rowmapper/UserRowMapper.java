package com.issuetracker.mvc.rowmapper;
import com.issuetracker.mvc.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 1/28/2015.
 */
public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt(1));
        user.setName(rs.getString(2));
       user.setUsername(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setCreated_date(rs.getDate(5));
        user.setStatus(rs.getString(7));
        user.setRole(rs.getString(8));
        return user;
    }
}
