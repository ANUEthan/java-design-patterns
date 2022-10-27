package com.iluwatar.rowdatagateway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowDataTest {
    @Test
    void obviousEquals() {
        var r1 = new RowData(1, "Joe", 20);
        var r2 = new RowData(1, "Joe", 20);
        assertEquals(r1.getID(),r2.getID());
        assertEquals(r1.getName(),r2.getName());
        assertEquals(r1.getValue(),r2.getValue());
    }

    @Test
    void idNotEquals() {
        assertNotEquals(new RowData(1, "Joe", 20), (new RowData(2, "Joe", 20)));
    }

    @Test
    void stringNotEquals() {
        assertNotEquals(new RowData(1, "Joe", 20), (new RowData(1, null, 20)));
    }

    @Test
    void valueNotEquals() {
        assertNotEquals(new RowData(1, "Joe", 20), (new RowData(1, "Joe", 21)));
    }

    @Test
    void setNameTest() {
        var r1 = new RowData(1, "Joe", 20);
        r1.setName("Joseph");
        assertEquals("Joseph", r1.getName());
    }

    @Test
    void setIDTest() {
        var r1 = new RowData(1, "Joe", 20);
        r1.setID(2);
        assertEquals(2, r1.getID());
    }

    @Test
    void setValueTest() {
        var r1 = new RowData(1, "Joe", 20);
        r1.setValue(21);
        assertEquals(21, r1.getValue());
    }
}
