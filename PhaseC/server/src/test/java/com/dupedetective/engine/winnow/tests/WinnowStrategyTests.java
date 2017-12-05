package com.dupedetective.engine.winnow.tests;

import com.dupedetective.engine.ASTLoopStrategy;
import com.dupedetective.engine.PDContext;
import com.dupedetective.engine.WinnowStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Winnow Strategy tests
 */
public class WinnowStrategyTests {
    private PDContext pdContext;
    private String testCode1, testCode2;

    @Before
    public void init() {
        pdContext = new PDContext(new WinnowStrategy());
        testCode1 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int j = 0; j < arr.length; j++) {i = arr[j];}} \n} ";
        testCode2 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int num : arr) {i = num;}} \n} ";
    }

    @Test
    public void testWinnowStrategy() {
        assertEquals(pdContext.executeStrategy(testCode1, testCode2).get(0).getScore(), 0, 0.001);
    }
}
