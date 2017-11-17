package engine.ast.tests;

import cs5500.project.engine.Parser;
import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.ASTHashVisitor;
import cs5500.project.engine.ast.ASTStructureVisitor;
import cs5500.project.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ASTHashVisitorTests {

    @Test
    public void testNodeListNotZero() {
        String testCode = "public class B { public void main(String[] args) {private float i = 9;} }";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTHashVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTHashVisitor) visitor).getList();

        assertTrue(hashedList.size() > 0);
    }


    @Test
    public void testTwoMethods() {
        String testCode = "package com.example.test;\nimport org.java.*; \n public class A { public A() {}; public void main(String[] args, String t) {" +
                 "i = k+2;" +
                "System.out.println(\"Hello World\");} }\n";

        String testCode2 = "package com.example.test;\nimport org.java.*; \n public class B { public B() {}; public void main(String[] args, String test) {" +
                "i = j+2;" + "System.out.println(\"Hello World\");} }\n";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor = new ASTHashVisitor();
        ASTVisitor visitor2 = new ASTHashVisitor();
        cu.accept(visitor);
        cu2.accept(visitor2);

        List<ASTHashObject> hashedList = ((ASTHashVisitor) visitor).getList();
        List<ASTHashObject> hashedList2 = ((ASTHashVisitor) visitor2).getList();

        System.out.println(hashedList.get(1).getHash() + " " + hashedList.get(1).getHash());
        assertTrue(hashedList.size() == 2);
    }

    @Test
    public void testBasicVariableDecl() {
        String testCode = "public class B { public void main(String[] args) {private float i = 9;} }";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTHashVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTHashVisitor) visitor).getList();

        System.out.println(hashedList.size());
        assertEquals((Long) 2704083857L, hashedList.get(0).getHash());
    }

    @Test
    public void testInitialization() {
        String testCode = "\n public class A { public A() {} \n" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i>10) j = 0; else j=1; \n }";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(new ArrayList<Integer>(), ((ASTStructureVisitor) visitor).getList());
    }

    @Test
    public void testIfElse() {
        String testCode = "\n public class A {" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i>10) j = 0; else j=1;} \n} ";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(new ArrayList<Integer>(), ((ASTStructureVisitor) visitor).getList());
    }

    @Test
    public void testArrayOps() {
        String testCode = "\n public class A { public A() {} \n" +
                "@Override\npublic String parse(String txt) {int i = 9;  \n int j; \n " +
                "if (i>10) j = 0; else j=1; \n txt.trim(); return txt;} " +
                "\n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }";

        Parser<CompilationUnit> astParser = new CustomASTParser();
        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTStructureVisitor();
        cu.accept(visitor);

        assertEquals(new ArrayList<Integer>(), ((ASTStructureVisitor) visitor).getList());
    }
}
