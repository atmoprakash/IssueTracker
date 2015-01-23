package com.springapp.mvc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by acer on 1/23/2015.
 */
public class DatabaseQuery {
    public boolean databaseQueryLogin(String u, String p) throws SQLException, ClassNotFoundException {
        boolean result = false;
        DatabaseConnection co = new DatabaseConnection();
        Connection c = co.DbConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * from user where password=? and fname=?");
        ps.setString(1, p);
        ps.setString(2, u);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            result = true;
        }
return result;
    }
}
