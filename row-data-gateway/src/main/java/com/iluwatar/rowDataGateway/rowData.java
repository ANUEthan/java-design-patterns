package com.iluwatar.rowDataGateway;

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
