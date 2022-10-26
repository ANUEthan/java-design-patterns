package com.iluwatar.rowDataGateway;

import java.sql.*;

public class App {
    private static final String urlDB = "jdbc:sqlite:test.db";

    private App() {

    }
    public static void main(String[] args) throws SQLException {
        initialize();

        rowData row1 = new rowData(1,"John",20);
        rowData row2 = new rowData(2,"Mary",30);
        rowData row3 = new rowData(3,"Doe",40);

        rowDataGateway rowGateway1 = new rowDataGateway(row1,urlDB);
        rowDataGateway rowGateway2 = new rowDataGateway(row2,urlDB);
        rowDataGateway rowGateway3 = new rowDataGateway(row3,urlDB);

        rowGateway1.insert();
        rowGateway2.insert();
        rowGateway3.insert();
        display();
        row3.setName("Dobothy");
        rowGateway3.setRowData(row3);
        rowGateway3.update();
        display();
        rowGateway2.delete();
        display();
        clearAll();
    }
    public static void initialize() {
        Statement stmt = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(urlDB);

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS rowDataTable " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " VALUE            INT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void clearAll() {
        Statement stmt = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(urlDB);

            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS rowDataTable";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void display() {
        Statement stmt = null;
        Connection c = null;
        try {
            c = DriverManager.getConnection(urlDB);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM rowDataTable;" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int value  = rs.getInt("value");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "VALUE = " + value );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
