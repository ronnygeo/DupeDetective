package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.ASTLoopStrategy;
import com.dupedetective.engine.ASTStructureStrategy;
import com.dupedetective.engine.PDContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AST Loop Strategy Tests
 */
public class ASTLoopStrategyTests {

    private PDContext pdContext;
    private String testCode1, testCode2;

    @Before
    public void init() {
        pdContext = new PDContext(new ASTLoopStrategy());
        testCode1 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int j = 0; j < arr.length; j++) {i = arr[j];}} \n} ";
        testCode2 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int num : arr) {i = num;}} \n} ";
    }

    @Test
    public void TestLoopStrategy() {

        assertEquals(pdContext.executeStrategy(testCode1, testCode2).get(0).getScore(), 0.4, 0.01);
    }

    @Test
    public void testMultipleStrategies() {
        // Changing strategy to Structure Strategy
        pdContext.setStrategy(new ASTStructureStrategy());
        assertEquals(pdContext.executeStrategy(testCode1, testCode2).get(0).getScore(), 0.5, 0.1);

    }
}