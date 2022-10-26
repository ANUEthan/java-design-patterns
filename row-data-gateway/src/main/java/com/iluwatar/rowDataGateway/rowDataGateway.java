package com.iluwatar.rowDataGateway;

import java.sql.*;

public class rowDataGateway {
    private rowData rowdata;
    private final String urlDB;
    public static Connection c = null;

    public rowDataGateway(rowData rowdata, String urlDB) {
        this.rowdata = rowdata;
        this.urlDB = urlDB;
    }

    public rowData getRowData() {
        return rowdata;
    }

    public void setRowData(rowData rowData) { this.rowdata = rowData; }

    public void insert() {

        Statement stmt = null;
        try {
            c = DriverManager.getConnection(urlDB);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO rowDataTable (ID,NAME,VALUE) " +
                    "VALUES ("+ rowdata.getID() +", '" + rowdata.getName() +"', "+ rowdata.getValue() +");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void update(){
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(urlDB);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "UPDATE rowDataTable set NAME = '"+ rowdata.getName() +"', VALUE = " + rowdata.getValue() + " where ID="+ rowdata.getID() +";";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public void delete() {
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(urlDB);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM rowDataTable WHERE NAME = '"+ rowdata.getName() +"' AND VALUE = " + rowdata.getValue() + " AND ID="+ rowdata.getID() +";";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
