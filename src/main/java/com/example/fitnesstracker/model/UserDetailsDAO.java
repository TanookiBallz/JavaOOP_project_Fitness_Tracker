package com.example.fitnesstracker.model;

import com.example.fitnesstracker.util.DBConnection;
import java.sql.*;

public class UserDetailsDAO {
    public static UserDetails getDetails(int userId) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
        ps.setInt(1,userId);
        ResultSet rs=ps.executeQuery();
        UserDetails d=null;
        if(rs.next()) {
            d=new UserDetails(rs.getInt("user_id"),rs.getDouble("height"),rs.getDouble("weight"),rs.getBoolean("is_male"),rs.getInt("age"),rs.getDouble("bmi"));
        }
        c.close();
        return d;
    }
    public static void insertDetails(UserDetails d) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("INSERT INTO user_details(user_id,height,weight,is_male,age,bmi) VALUES(?,?,?,?,?,?)");
        ps.setInt(1,d.getUserId());
        ps.setDouble(2,d.getHeight());
        ps.setDouble(3,d.getWeight());
        ps.setBoolean(4,d.isMale());
        ps.setInt(5,d.getAge());
        ps.setDouble(6,d.getBmi());
        ps.executeUpdate();
        c.close();
    }
    public static void updateDetails(UserDetails d) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("UPDATE user_details SET height=?,weight=?,is_male=?,age=?,bmi=? WHERE user_id=?");
        ps.setDouble(1,d.getHeight());
        ps.setDouble(2,d.getWeight());
        ps.setBoolean(3,d.isMale());
        ps.setInt(4,d.getAge());
        ps.setDouble(5,d.getBmi());
        ps.setInt(6,d.getUserId());
        ps.executeUpdate();
        c.close();
    }
}