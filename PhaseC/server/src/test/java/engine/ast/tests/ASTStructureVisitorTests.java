package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.visitor.ASTStructureVisitor;
import com.dupedetective.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * AST Structure visitor tests
 */
public class ASTStructureVisitorTests {
    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
        astParser = new CustomASTParser();
    }

    @Test
    public void testBasicDecl() {
        String testCode = "package com.example.test;\nimport org.java.*; \n public class A { public void main(String[] args) {System.out.println(\"Hello World\");} }\n";

        CompilationUnit cu = astParser.parse(testCode);
        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(19, ((ASTStructureVisitor) visitor).getList().size());
    }

    @Test
    public void testBasicDecl2() {
        String testCode = "public class B { private float i = 9; }";
        CompilationUnit cu = astParser.parse(testCode);
        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(8, ((ASTStructureVisitor) visitor).getList().size());
    }

    @Test
    public void testInitialization() {
        String testCode = "\n public class A { public A() {} \n" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i>10) j = 0; else j=1; \n }";

        CompilationUnit cu = astParser.parse(testCode);
        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(33, ((ASTStructureVisitor) visitor).getList().size());
    }

    @Test
    public void testIfElse() {
        String testCode = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i>10) j = 0; else j=1;} \n} ";
        CompilationUnit cu = astParser.parse(testCode);
        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(30, ((ASTStructureVisitor) visitor).getList().size());
    }

    @Test
    public void testArrayOps() {
        String testCode = "\n public class A { \n" +
                "@Override\npublic String parse(String txt) {ArrayList<Integer> al = new ArrayList<Integer>();j=1000;}}";
        CompilationUnit cu = astParser.parse(testCode);
        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(22, ((ASTStructureVisitor) visitor).getList().size());
    }

    @Test
    public void testIfSwitch() {
        String testCode1 = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i == 10) j = 0; else j=1;} \n} ";
        String testCode2 = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "switch(i) {case 10: j = 0; break; default: j=1; break;}} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTStructureVisitor();
        ASTVisitor visitor2 = new ASTStructureVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertNotEquals(((ASTStructureVisitor) visitor1).getList().get(0), ((ASTStructureVisitor) visitor2).getList().get(0));
    }
}
