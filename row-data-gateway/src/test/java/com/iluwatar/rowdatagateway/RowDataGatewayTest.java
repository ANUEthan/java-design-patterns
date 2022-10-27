package com.iluwatar.rowdatagateway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RowDataGatewayTest {
    @Test
    void initialiseTest() {
        assertDoesNotThrow(()->App.initialize());
        App.clearAll();
    }

    @Test
    void clearAllTest() {
        assertDoesNotThrow(()->App.clearAll());
    }

    @Test
    void insertTest() {
        var r1 = new RowData(1,"s",1);
        App.initialize();
        RowDataGateway rDG1 = new RowDataGateway(r1,"jdbc:sqlite:test.db");
        assertDoesNotThrow(()->rDG1.insert());
        App.clearAll();
    }

    @Test
    void updateTest() {
        var r1 = new RowData(1,"s",1);
        var r2 = new RowData(1,"t",2);
        App.initialize();
        RowDataGateway rDG1 = new RowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.insert();
        rDG1.setRowData(r2);
        assertDoesNotThrow(()->rDG1.update());
        App.clearAll();
    }

    @Test
    void deleteTest() {
        var r1 = new RowData(1,"s",1);
        App.initialize();
        RowDataGateway rDG1 = new RowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.insert();
        assertDoesNotThrow(()->rDG1.delete());
        App.clearAll();
    }

    @Test
    void setRowDataTest() {
        var r1 = new RowData(1,"s",1);
        var r2 = new RowData(1,"t",2);
        RowDataGateway rDG1 = new RowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.setRowData(r2);
        assertEquals(r2,rDG1.getRowData());
    }
}
