package com.issuetracker.mvc.rowmapper;

import com.issuetracker.mvc.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 1/25/2015.
 */
public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user= new User();
        user.setId(rs.getInt(1));
        user.setUsername(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setCreated_date(rs.getString(4));
        user.setCreated_by(rs.getString(5));
        return user;
    }

}
