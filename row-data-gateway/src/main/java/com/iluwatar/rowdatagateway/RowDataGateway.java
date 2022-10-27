package com.iluwatar.rowdatagateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RowDataGateway {
  /**
   * Variables to store the URL and rowData.
   */
  private RowData rowdata;
  private final String urlDB;
  public static Connection c = null;

  /**
   * Public constructor.
   * @param rowdata rowData
   * @param urlDB String
   */
  public RowDataGateway(RowData rowdata, String urlDB) {
    this.rowdata = rowdata;
    this.urlDB = urlDB;
  }

  /**
   * Method to get current rowData.
   */
  public RowData getRowData() {
    return rowdata;
  }
  /**
   * Method to set the current rowData, useful when preparing for Update for example.
   * @param rowData rowData
   */
  public void setRowData(RowData rowData) {
    this.rowdata = rowData;
  }

  /**
   * Insert part of the Data Pattern.
   * Purpose is to insert the current rowData in scope into the SQL table.
   */
  public void insert() {

    Statement stmt = null;
    try {
      c = DriverManager.getConnection(urlDB);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO rowDataTable (ID,NAME,VALUE) " + "VALUES (" + rowdata.getID() + ", '" + rowdata.getName() + "', " + rowdata.getValue() + ");";
      System.out.println(sql);
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
  /**
   * Update part of the Data Pattern.
   * Purpose is to update the row with matching ID to the new rowData.
   */
  public void update() {
    Statement stmt = null;
    try {
      c = DriverManager.getConnection(urlDB);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "UPDATE rowDataTable set NAME = '" + rowdata.getName() + "', VALUE = " + rowdata.getValue() + " where ID=" + rowdata.getID() + ";";
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
  /**
   * Delete part of the Data Pattern.
   * Purpose is to update the row with matching ID to the new rowData.
   */
  public void delete() {
    Statement stmt = null;
    try {
      c = DriverManager.getConnection(urlDB);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "DELETE FROM rowDataTable WHERE NAME = '" + rowdata.getName() + "' AND VALUE = " + rowdata.getValue() + " AND ID=" + rowdata.getID() + ";";
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}
