package com.Music.JukeBox.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JukeBoxConnection {
    public static Connection getJukeBoxConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox1","root","password");
        return connection;
    }
}
