package com.iluwatar.rowDataGateway;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Database {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite::memory:test.db";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}
