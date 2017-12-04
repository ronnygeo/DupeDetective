package com.dupedetective.engine.ast.tests;

import static org.junit.Assert.*;

import com.dupedetective.engine.ASTLoopStrategy;
import com.dupedetective.engine.PDContext;
import org.junit.Test;

/**
 * AST Loop Strategy Tests
 */
public class ASTLoopStrategyTests {
    @Test
    public void TestLoopStrategy() {
        String testCode1 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int j = 0; j < arr.length; j++) {i = arr[j];}} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic void forLoop(int[] arr) { \n " +
                "for(int num : arr) {i = num;}} \n} ";
        PDContext loop = new PDContext(new ASTLoopStrategy());
        assertEquals(loop.executeStrategy(testCode1, testCode2).get(0).getScore(), 0.4, 0.01);
    }
}