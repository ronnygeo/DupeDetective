package com.dupedetective.engine.ast.tests;

import com.dupedetective.engine.ASTStructureStrategy;
import com.dupedetective.engine.PDContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing AST Structure Strategy
 */
public class ASTStructureStrategyTests {

    PDContext structureStrategy;

    @Before
    public void init() {
        structureStrategy = new PDContext(new ASTStructureStrategy());
    }

    @Test
    public void testSameStructure() {
        String testCode1 = "\npackage a;\n" + "public class A {\n" + "private int x;\n" +
                "public void setX(int x) {\n" + "this.x = x;\n" + "}}";
        String testCode2 = "\npackage b;\n" + "public class B {\n" +
                "private int y;\n" + "public void assignY(int y) {\n" + "this.y = y;\n" + "}}";
        assertEquals(structureStrategy.executeStrategy(testCode1, testCode2).get(0).getScore(), 1.0, 0.01);

    }

    @Test
    public void testDifferentStructure() {
        String testCode1 = "\npackage a;\n" + "public class A {\n" + "private int x;\n" +
                "public void setX(int x) {\n" + "this.x = x;\n" + "}}";
        String testCode2 = "import com.a.*;\n" + "public class A {\n" +
                "public static void main(String args[]) {\n" + "int x;\n" + "}}\n";
        assertEquals(structureStrategy.executeStrategy(testCode1, testCode2).get(0).getScore(), 0.5, 0.01);
    }

}
