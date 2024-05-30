package com.opentext.assignment.linereader;

import junit.framework.TestCase;
import com.opentext.assignment.linereader.Input;

public class InputTest extends TestCase {

    public void testInsert() {
        var input = new Input("ins 1");
        assertEquals(input.getFlag(), "ins");
        assertEquals(input.getValueAsInteger(), Integer.valueOf(1));
    }

    public void testDelete() {
        var input = new Input("del 1");
        assertEquals(input.getFlag(), "del");
        assertEquals(input.getValueAsInteger(), Integer.valueOf(1));
    }

}
