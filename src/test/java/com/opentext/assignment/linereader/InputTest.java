package com.opentext.assignment.linereader;

import junit.framework.TestCase;
import com.opentext.assignment.linereader.Input;

public class InputTest extends TestCase {

    public void testInsert_happypath() {
        var input = new Input("ins 1");
        assertEquals(input.getFlag(), "ins");
        assertEquals(input.getValueAsInteger(), Integer.valueOf(1));
    }

    public void testInsert_no_line_number() {
        var input = new Input("ins");
        assertEquals(input.getFlag(), "ins");
        assertEquals(input.getValueAsInteger(), null);
    }

    public void testDelete_happypath_no_line_number() {
        var input = new Input("del");
        assertEquals(input.getFlag(), "del");
        assertEquals(input.getValueAsInteger(), null);
    }

    public void testInsert_invalid_line_number() {
        var input = new Input("ins xx");
        assertEquals(input.getFlag(), "ins");
        assertEquals(input.getValueAsInteger(), null);
    }

    public void testDelete_invalid_line_number() {
        var input = new Input("del xx");
        assertEquals(input.getFlag(), "del");
        assertEquals(input.getValueAsInteger(), null);
    }

}
