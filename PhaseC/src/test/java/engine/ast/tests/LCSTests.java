package engine.ast.tests;

import cs5500.project.engine.ast.LCSCompare;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for LCS Comparison of two lists
 */
public class LCSTests {
    @Test
    public void testBasicSequence() {
        List<Long> l1 = Arrays.asList(1l,2l,1l,5l,6l,2l,3l);
        List<Long> l2 = Arrays.asList(1l,2l,1l,1l,2l,3l);
        LCSCompare lcsc = new LCSCompare();
        assertEquals(0.71, lcsc.compare(l1, l2), 5);
    }
}
