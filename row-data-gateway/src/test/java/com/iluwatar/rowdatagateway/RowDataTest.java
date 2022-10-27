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
