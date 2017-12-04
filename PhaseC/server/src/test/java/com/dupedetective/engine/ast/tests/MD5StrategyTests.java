package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.MD5Strategy;
import com.dupedetective.engine.PDContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for MD5 Strategy
 */
public class MD5StrategyTests {
    PDContext md5Strategy;

    @Before
    public void init() {
        md5Strategy = new PDContext(new MD5Strategy());
    }

    @Test
    public void testSameCode() {
        String testCode1 = "\npackage a;\n" + "public class A {\n" + "private int x;\n" +
                "public void setX(int x) {\n" + "this.x = x;\n" + "}}";
        String testCode2 = "\npackage a;\n" + "public class A {\n" + "private int x;\n" +
                "public void setX(int x) {\n" + "this.x = x;\n" + "}}";
        assertEquals(md5Strategy.executeStrategy(testCode1, testCode2).get(0).getScore(), 1.0, 0.001);
    }

    @Test
    public void testDiffCode() {
        String testCode1 = "\npackage a;\n" + "public class A {\n" + "private int x;\n" +
                "public void setX(int x) {\n" + "this.x = x;\n" + "}}";
        String testCode2 = "\npackage b;\n" + "public class B {\n" +
                "private int y;\n" + "public void assignY(int y) {\n" + "this.y = y;\n" + "}}";
        assertEquals(md5Strategy.executeStrategy(testCode1, testCode2).get(0).getScore(), 0, 0.001);
    }
}
