package assignment.opentext;

import junit.framework.TestCase;
import linereader.assignment.opentext.Input;

public class InputTest extends TestCase {

    public void testInsert() {
        var input = new Input("ins 1");
        assertEquals(input.getFlag(), "ins");
        assertEquals(input.getValueAsInteger(), Integer.valueOf(1));
    }
}
