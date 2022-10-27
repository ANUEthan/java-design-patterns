package com.iluwatar.rowdatagateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This acts as a 'Gateway' to a single record in a database, with one instance per row.
 * Here, 'Gateway' means that it enables the user to interact with the SQL database without directly using SQL language.
 *
 * <p>In this example, I use the row data gateway pattern to access a rowData table.
 * The main method initialises an instance of {@link RowDataGateway}
 * for each row, allowing access and interactions with each row in the database
 * through Insert, Update and Delete methods in {@link RowDataGateway}</p>
 */
public class App {
  /**
   * The URL that determines the database to connect to. In this example code, this is SQLLite's test database.
   */
  private static final String urlDB = "jdbc:sqlite:test.db";
  /**
   * Private, empty constructor.
   */
  private App() {
  }
  /**
   * Starting point for the program.
   * @param args command line args
   * @throws  SQLException if any error occur, since SQL code is necessary in  {@link RowDataGateway}
   */
  public static void main(String[] args) throws SQLException {
    //starting method to create a the table rowData and establish a connection to the database.
    initialize();

    //create three rowData objects and create three rowDataGateways to access the database.
    RowData row1 = new RowData(1,"John",20);
    RowData row2 = new RowData(2,"Mary",30);
    RowData row3 = new RowData(3,"Doe",40);

    RowDataGateway rowGateway1 = new RowDataGateway(row1,urlDB);
    RowDataGateway rowGateway2 = new RowDataGateway(row2,urlDB);
    RowDataGateway rowGateway3 = new RowDataGateway(row3,urlDB);

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
    //clear table and reset the database, ending the connection also.
    clearAll();
  }
  /**
   * Initializes the connection to the database and creates table to interact with in this example.
  */
  public static void initialize() {
    Statement stmt = null;
    Connection c = null;
    try {
      c = DriverManager.getConnection(urlDB);

      stmt = c.createStatement();
      String sql = "CREATE TABLE IF NOT EXISTS rowDataTable " + "(ID INT PRIMARY KEY NOT NULL," + " NAME TEXT NOT NULL, " + " VALUE INT NOT NULL)";
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
  /**
   * Deletes the table and ends the connection to the database.
  */
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
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }

  /**
   * Prints the database row-by-row to the terminal, useful in testing and understanding the code.
  */
  public static void display() {
    Statement stmt = null;
    Connection c = null;
    try {
      c = DriverManager.getConnection(urlDB);
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM rowDataTable;");

      while (rs.next()) {
        int id = rs.getInt("id");
        String  name = rs.getString("name");
        int value  = rs.getInt("value");

        System.out.println("ID = " + id);
        System.out.println("NAME = " + name);
        System.out.println("VALUE = " + value);
        System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}
