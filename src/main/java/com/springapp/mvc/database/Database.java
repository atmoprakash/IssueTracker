package com.springapp.mvc.database;

import com.springapp.mvc.model.User;

import java.sql.*;

/**
 * Created by acer on 1/21/2015.
 */
public class Database {


    public boolean DbConnection(String u, String p) throws SQLException, ClassNotFoundException {
        boolean result=false;
        User stu=new User();
        try {
            String url = "jdbc:mysql://localhost:3306/eclipsedb";
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver).newInstance();
            Connection con = DriverManager.getConnection(url, "root", "admin");

            PreparedStatement ps = con.prepareStatement("SELECT * from user where password=? and fname=?");
            ps.setString(1, p);
            ps.setString(2, u);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                String fname=stu.getUsername();
                result=true;
            }
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
return result;

    }
}
