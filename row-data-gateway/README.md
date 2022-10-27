---
title: Row Data Gateway
category: Structural
language: en
tags:
 - Data access
---

## Also known as


## Intent

Acts a Gateway to a single record in a database. One instance per row. Contains no domain logic.

## Explanation

Real-world example

> Consider your company wants to reduce their reliance on SQL-literate employees
> To achieve this, they create a Row Data Gateway within their software
> This allows for ordinary employees to interact with SQL without knowing SQL-specific language

In Plain Words

> Row Data Gateway is about accessing a row in a Database without the user having to directly use SQL.

**Programmatic Example**

A Row Data Gateway acts as an object that mimics a single record, i.e. a single row of a database.
In my example, 'rowData' class has id, Name and Value fields.

The `rowData` class:
```java
public class rowData {
    private int id;
    private String name;
    private int value;

    /**
     * Public constructor
     * @param i int
     * ^^^ this is the ID of the row, should always be present
     * the following data types and the number of them should vary depending on the Columns of the SQL Table
     * @param s String
     * @param i1 int
     */
    public rowData(int i, String s, int i1) {
        this.id=i;
        this.name=s;
        this.value=i1;
    }
    /**
     * Gets current name of the rowData
     */
    public String getName() {
        return name;
    }

    /**
     * Sets current name of the rowData
     * @param name String
     */
    public void setName(String name) { this.name = name; }
    /**
     * Gets current Value of the rowData
     */
    public int getValue() {
        return value;
    }
    /**
     * Sets current value of the rowData
     * @param value int
     */
    public void setValue(int value) { this.value = value; }
    /**
     * Gets current ID of the rowData
     */
    public int getID() { return id; }
    /**
     * Sets current ID of the rowData
     * @param id int
     */
    public void setID(int id) { this.id = id; }
}
```

The features in the above class correlate to the features of the column of the table.
This class holds the data about a row so that a client can access the Row Data Gateway directly.
The gateway acts as an interface for each row of data in the database.

The `rowDataGateway` class:
```java
public class rowDataGateway {
    /**
     * Variables to store the URL and rowData
     */
    private rowData rowdata;
    private final String urlDB;
    public static Connection c = null;

    /**
     * Public constructor
     * @param rowdata rowData
     * @param urlDB String
     */
    public rowDataGateway(rowData rowdata, String urlDB) {
        this.rowdata = rowdata;
        this.urlDB = urlDB;
    }

    /**
     * Method to get current rowData
     */
    public rowData getRowData() {
        return rowdata;
    }
    /**
     * Method to set the current rowData, useful when preparing for Update for example.
     * @param rowData rowData
     */
    public void setRowData(rowData rowData) { this.rowdata = rowData; }

    /**
     * Insert part of the Data Pattern
     * Purpose is to insert the current rowData in scope into the SQL table!
     */
    public void insert() {
        ...
    }
    /**
     * Update part of the Data Pattern
     * Purpose is to update the row with matching ID to the new rowData
     */
    public void update(){
        ...
    }
    /**
     * Delete part of the Data Pattern
     * Purpose is to update the row with matching ID to the new rowData
     */
    public void delete() {
        ...
    }    
}
```
The App class acts as the external software implementing this design pattern, and shows how to insert, update and delete.
The `App` class:
```java
import java.sql.*;
public class App {
    /**
     * The URL that determines the database to connect to. In this example code, this is SQLLite's test database.
     */
    private static final String urlDB = "jdbc:sqlite:test.db";
    /**
     * Private, empty constructor
     */
    private App() {
    }
    /**
     * Starting point for the program
     * @param args command line args
     * @throws  SQLException if any error occur, since SQL code is necessary in  {@link rowDataGateway}
     */
    public static void main(String[] args) throws SQLException {
        //starting method to create a the table rowData and establish a connection to the database.
        initialize();

        //create three rowData objects and create three rowDataGateways to access the database.
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
        //clear table and reset the database, ending the connection also.
        clearAll();
    }
    /**
     * Initializes the connection to the database and creates table to interact with in this example.
     */
    public static void initialize() {
        ...
    }
    /**
     * Deletes the table and ends the connection to the database.
     */
    public static void clearAll() {
        ...
    }

    /**
     * Prints the database row-by-row to the terminal, useful in testing and understanding the code!
     */
    public static void display() {
        ...
    }
}
```
Here's the console output. You can see the three calls of display() printed. Display is not necessary for the Pattern,
but it is useful to help understand the process.

```
INSERT INTO rowDataTable (ID,NAME,VALUE) VALUES (1, 'John', 20);
INSERT INTO rowDataTable (ID,NAME,VALUE) VALUES (2, 'Mary', 30);
INSERT INTO rowDataTable (ID,NAME,VALUE) VALUES (3, 'Doe', 40);
ID = 1
NAME = John
VALUE = 20

ID = 2
NAME = Mary
VALUE = 30

ID = 3
NAME = Doe
VALUE = 40

ID = 1
NAME = John
VALUE = 20

ID = 2
NAME = Mary
VALUE = 30

ID = 3
NAME = Dobothy
VALUE = 40

ID = 1
NAME = John
VALUE = 20

ID = 3
NAME = Dobothy
VALUE = 40


Process finished with exit code 0
```

## Class diagram

![alt text](./etc/RowDataGateway.png "Row Data Gateway class diagram")

## Applicability

Row Data Gateway is often used with the Transaction Script pattern. In this case, it factors out the database access code and allows easy reuse by different Transaction Scripts.

## Related patterns

- Active Record Pattern

- [Transaction Script](https://java-design-patterns.com/patterns/transaction-script/)

## Tutorial

* [Bridge Pattern Tutorial](https://www.journaldev.com/1491/bridge-design-pattern-java)

## Credits

* [Row Data Gateway Pattern](https://www.sourcecodeexamples.net/2018/04/row-data-gateway.html)
* [SQLite - Java](https://www.tutorialspoint.com/sqlite/sqlite_java.htm)
