package com.iluwatar.rowDataGateway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class rowDataTest {
    @Test
    void obviousEquals() {
        rowData r1 = new rowData(1, "Joe", 20);
        rowData r2 = new rowData(1, "Joe", 20);
        assertEquals(r1.getID(),r2.getID());
        assertEquals(r1.getName(),r2.getName());
        assertEquals(r1.getValue(),r2.getValue());
    }

    @Test
    void idNotEquals() {
        assertNotEquals(new rowData(1, "Joe", 20), (new rowData(2, "Joe", 20)));
    }

    @Test
    void stringNotEquals() {
        assertNotEquals(new rowData(1, "Joe", 20), (new rowData(1, null, 20)));
    }

    @Test
    void valueNotEquals() {
        assertNotEquals(new rowData(1, "Joe", 20), (new rowData(1, "Joe", 21)));
    }

    @Test
    void setNameTest() {
        rowData r1 = new rowData(1, "Joe", 20);
        r1.setName("Joseph");
        assertEquals("Joseph", r1.getName());
    }

    @Test
    void setIDTest() {
        rowData r1 = new rowData(1, "Joe", 20);
        r1.setID(2);
        assertEquals(2, r1.getID());
    }

    @Test
    void setValueTest() {
        rowData r1 = new rowData(1, "Joe", 20);
        r1.setValue(21);
        assertEquals(21, r1.getValue());
    }
}
