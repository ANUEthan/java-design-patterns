/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.rowdatagateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RowDataGateway {
  /**
   * Logger.
   */
  private static final Logger logger = LoggerFactory.getLogger(RowDataGateway.class);

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
      logger.info(sql);
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception e) {
      logger.info(e.getClass().getName() + ": " + e.getMessage());
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
      logger.info(sql);
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
    } catch (Exception e) {
      logger.info(e.getClass().getName() + ": " + e.getMessage());
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
      logger.info(sql);
      stmt.executeUpdate(sql);
      c.commit();
      stmt.close();
      c.close();
    } catch (Exception e) {
      logger.info(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}
