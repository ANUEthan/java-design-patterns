package com.iluwatar.rowDataGateway;

public class rowData {
    private int id;
    private String name;
    private int value;

    public rowData(int i, String s, int i1) {
        this.id=i;
        this.name=s;
        this.value=i1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getValue() {
        return value;
    }

    public void setValue(int value) { this.value = value; }

    public int getID() { return id; }

    public void setID(int id) { this.id = id; }
}
