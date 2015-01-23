package com.springapp.mvc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by acer on 1/21/2015.
 */
public class DatabaseConnection {
    public Connection DbConnection() throws SQLException, ClassNotFoundException {
        Connection con=null;
        try {
            String url = "jdbc:mysql://localhost:3306/eclipsedb";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, "root", "admin");
            } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return con;
    }
}
