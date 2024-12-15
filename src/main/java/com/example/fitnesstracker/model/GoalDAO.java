package com.example.fitnesstracker.model;

import com.example.fitnesstracker.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDAO {
    public static void insertGoal(Goal g) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("INSERT INTO goals(user_id,goal_description) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,g.getUserId());
        ps.setString(2,g.getGoalDescription());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()) g.setId(rs.getInt(1));
        c.close();
    }
    public static List<Goal> getUserGoals(int userId) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT * FROM goals WHERE user_id=?");
        ps.setInt(1,userId);
        ResultSet rs=ps.executeQuery();
        List<Goal> list=new ArrayList<>();
        while(rs.next()) {
            list.add(new Goal(rs.getInt("id"),rs.getInt("user_id"),rs.getString("goal_description")));
        }
        c.close();
        return list;
    }
}