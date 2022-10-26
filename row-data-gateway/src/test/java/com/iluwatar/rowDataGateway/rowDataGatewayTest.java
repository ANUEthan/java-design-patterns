package com.iluwatar.rowDataGateway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class rowDataGatewayTest {
    @Test
    void initialiseTest() {
        assertDoesNotThrow(App::initialize);
        App.clearAll();
    }

    @Test
    void clearAllTest() {
        assertDoesNotThrow(App::clearAll);
    }

    @Test
    void insertTest() {
        rowData r1 = new rowData(1,"s",1);
        App.initialize();
        rowDataGateway rDG1 = new rowDataGateway(r1,"jdbc:sqlite:test.db");
        assertDoesNotThrow(rDG1::insert);
        App.clearAll();
    }

    @Test
    void updateTest() {
        rowData r1 = new rowData(1,"s",1);
        rowData r2 = new rowData(1,"t",2);
        App.initialize();
        rowDataGateway rDG1 = new rowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.insert();
        rDG1.setRowData(r2);
        assertDoesNotThrow(rDG1::update);
        App.clearAll();
    }

    @Test
    void deleteTest() {
        rowData r1 = new rowData(1,"s",1);
        App.initialize();
        rowDataGateway rDG1 = new rowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.insert();
        assertDoesNotThrow(rDG1::delete);
        App.clearAll();
    }

    @Test
    void setRowDataTest() {
        rowData r1 = new rowData(1,"s",1);
        rowData r2 = new rowData(1,"t",2);
        rowDataGateway rDG1 = new rowDataGateway(r1,"jdbc:sqlite:test.db");
        rDG1.setRowData(r2);
        assertEquals(r2,rDG1.getRowData());
    }
}
