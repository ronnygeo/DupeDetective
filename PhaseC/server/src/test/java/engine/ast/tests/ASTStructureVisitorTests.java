package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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

        assertEquals(7, ((ASTStructureVisitor) visitor).getList().size());
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

        assertEquals(19, ((ASTStructureVisitor) visitor).getList().size());
    }
}
