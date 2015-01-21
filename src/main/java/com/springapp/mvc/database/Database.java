package com.springapp.mvc.database;

import java.sql.*;

/**
 * Created by acer on 1/21/2015.
 */
public class Database {
    boolean result = false;

    public boolean DbConnection(String u, String p) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/eclipsedb";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            Connection con = DriverManager.getConnection(url, "root", "admin");

            PreparedStatement ps = con.prepareStatement("SELECT * from student where password=? and fname=?");
            ps.setString(1, u);
            ps.setString(2, p);
            int a = ps.executeUpdate();
            if (a > 0) {
                result = true;
            }
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
return result;

    }
}
