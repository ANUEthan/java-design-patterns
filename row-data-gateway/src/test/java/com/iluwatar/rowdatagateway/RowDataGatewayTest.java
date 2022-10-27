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
