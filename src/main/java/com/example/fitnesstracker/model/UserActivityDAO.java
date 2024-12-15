package com.example.fitnesstracker.model;

import com.example.fitnesstracker.util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserActivityDAO {
    public static void insertActivity(UserActivity a) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("INSERT INTO user_activity(user_id,activity_date,steps,water_ml,calories) VALUES(?,?,?,?,?)");
        ps.setInt(1,a.getUserId());
        ps.setDate(2,Date.valueOf(a.getActivityDate()));
        ps.setInt(3,a.getSteps());
        ps.setInt(4,a.getWaterMl());
        ps.setInt(5,a.getCalories());
        ps.executeUpdate();
        c.close();
    }
    public static List<UserActivity> getActivities(int userId) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT * FROM user_activity WHERE user_id=? ORDER BY activity_date DESC");
        ps.setInt(1,userId);
        ResultSet rs=ps.executeQuery();
        List<UserActivity> list=new ArrayList<>();
        while(rs.next()) {
            list.add(new UserActivity(rs.getInt("id"),rs.getInt("user_id"),rs.getDate("activity_date").toLocalDate(),rs.getInt("steps"),rs.getInt("water_ml"),rs.getInt("calories")));
        }
        c.close();
        return list;
    }
}