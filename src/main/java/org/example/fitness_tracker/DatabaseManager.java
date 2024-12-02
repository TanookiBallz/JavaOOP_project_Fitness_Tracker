package org.example.fitness_tracker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/fitness_tracker";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    public static void initializeDatabase() {
        try (Connection conn = connect()) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, weight REAL, height REAL)");
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS activities (id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER, activity_type TEXT, duration INTEGER, calories_burned REAL, date TEXT, FOREIGN KEY (user_id) REFERENCES users(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}