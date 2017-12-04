package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.ASTMethodStrategy;
import com.dupedetective.engine.PDContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * AST Method Strategy Tests
 */
public class ASTMethodStrategyTests {

    @Test
    public void testMethodStrategy() {
        String testCode1 = "\npublic class A {" +
                "\nprivate int x;\n" +
                "public void assignX(int x){\n" +
                "this.x = x;\n" +
                "}}";
        String testCode2 = "\npublic class A {" +
                "\nprivate int x;\n" +
                "public void setX(){\n" +
                "this.x = 5;\n" +
                "}}";

        PDContext method = new PDContext(new ASTMethodStrategy());
        assertEquals(method.executeStrategy(testCode1, testCode2).get(0).getScore(), 0.8, 0.01);
    }

}
