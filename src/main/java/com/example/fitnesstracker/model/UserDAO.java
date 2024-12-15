package com.example.fitnesstracker.model;

import com.example.fitnesstracker.util.DBConnection;
import java.sql.*;

public class UserDAO {
    public static User getUserByEmail(String email) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT * FROM users WHERE email=?");
        ps.setString(1,email);
        ResultSet rs=ps.executeQuery();
        User u=null;
        if(rs.next()) {
            u=new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
                    rs.getString("password_hash"),rs.getString("phone"),rs.getBoolean("is_admin"),rs.getBoolean("first_login"));
        }
        c.close();
        return u;
    }
    public static void insertUser(User u) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("INSERT INTO users(name,email,password_hash,phone,is_admin,first_login) VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,u.getName());
        ps.setString(2,u.getEmail());
        ps.setString(3,u.getPasswordHash());
        ps.setString(4,u.getPhone());
        ps.setBoolean(5,u.isAdmin());
        ps.setBoolean(6,u.isFirstLogin());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()) u.setId(rs.getInt(1));
        c.close();
    }
    public static void updateUser(User u) throws Exception {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("UPDATE users SET name=?,email=?,password_hash=?,phone=?,is_admin=?,first_login=? WHERE id=?");
        ps.setString(1,u.getName());
        ps.setString(2,u.getEmail());
        ps.setString(3,u.getPasswordHash());
        ps.setString(4,u.getPhone());
        ps.setBoolean(5,u.isAdmin());
        ps.setBoolean(6,u.isFirstLogin());
        ps.setInt(7,u.getId());
        ps.executeUpdate();
        c.close();
    }
    public static java.util.List<User> getAllUsers() throws Exception {
        Connection c=DBConnection.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM users");
        java.util.List<User> list=new java.util.ArrayList<>();
        while(rs.next()) {
            list.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
                    rs.getString("password_hash"),rs.getString("phone"),rs.getBoolean("is_admin"),rs.getBoolean("first_login")));
        }
        c.close();
        return list;
    }
}