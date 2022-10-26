package com.iluwatar.rowDataGateway;

import java.sql.*;

public class rowDataGateway extends rowData {
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void Insert() {
    }

    public void Update(){

    }

    public Boolean Delete() {
        return false;
    }
}
