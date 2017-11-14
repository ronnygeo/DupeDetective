package engine.ast.tests;

import cs5500.project.engine.ast.LCSCompare;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LCSTests {
    @Test
    public void testBasicSequence() {
        List<Integer> l1 = Arrays.asList(1,2,1,5,6,2,3);
        List<Integer> l2 = Arrays.asList(1,2,1,1,2,3);
        LCSCompare lcsc = new LCSCompare();
        assertEquals(0.71, lcsc.compare(l1, l2), 0.01);
    }
}
