package com.iluwatar.rowDataGateway;

public class rowDataGateway extends rowData {
    private String name;
    private double value;
    private int numberOfDependents;

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

    public int getNumDependents() {
        return numberOfDependents;
    }

    public void setNumDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }
}
