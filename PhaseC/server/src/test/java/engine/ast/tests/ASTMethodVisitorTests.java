package engine.ast.tests;

import com.dupedetective.engine.Parser;
import com.dupedetective.engine.ast.ASTHashObject;
import com.dupedetective.engine.ast.visitor.ASTMethodVisitor;
import com.dupedetective.engine.ast.CustomASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * AST method visitor tests
 */
public class ASTMethodVisitorTests {

    private Parser<CompilationUnit> astParser;

    @Before
    public void setup() {
         astParser = new CustomASTParser();
    }

    @Test
    public void testNoMethod() {
        String testCode = "public class B { private float i = 9; }";

        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTMethodVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTMethodVisitor) visitor).getList();

        assertTrue(hashedList.size() == 0);
    }

    @Test
    public void testNodeListNotZero() {
        String testCode = "public class B { public void main(String[] args) {private float i = 9;} }";

        CompilationUnit cu = astParser.parse(testCode);

        ASTVisitor visitor = new ASTMethodVisitor();
        cu.accept(visitor);

        List<ASTHashObject> hashedList = ((ASTMethodVisitor) visitor).getList();

        assertTrue(hashedList.size() > 0);
    }

    @Test
    public void testTwoMethods() {
        String testCode = "package com.example.test;\nimport org.java.*; \n public class A { public A() {}; public void main(String[] args, String t) {" +
                 "i = k+2;" +
                "System.out.println(\"Hello World\");} }\n";

        String testCode2 = "package com.example.test;\nimport org.java.*; \n public class B { public B() {}; public void main(String[] args, String test) {" +
                "i = j+2;" + "System.out.println(\"Hello World\");} }\n";

        CompilationUnit cu = astParser.parse(testCode);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu.accept(visitor);
        cu2.accept(visitor2);

        List<ASTHashObject> hashedList = ((ASTMethodVisitor) visitor).getList();
        List<ASTHashObject> hashedList2 = ((ASTMethodVisitor) visitor2).getList();

        assertTrue(hashedList.size() == hashedList2.size());
    }
    
    @Test
    public void testMethodDifferentParams() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(Integer num) {} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(Float num) {} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertNotEquals(((ASTMethodVisitor) visitor1).getList().get(0).getHash(), ((ASTMethodVisitor) visitor2).getList().get(0).getHash());
    }

    @Test
    public void testMethodMultipleParams() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(Integer num) {} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(Integer num, Float num2) {} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertNotEquals(((ASTMethodVisitor) visitor1).getList().get(0).getHash(), ((ASTMethodVisitor) visitor2).getList().get(0).getHash());
    }

    @Test
    public void testMethodDifferentReturn() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"hello\";} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"Hello!\";} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertEquals(((ASTMethodVisitor) visitor1).getList().get(0).getNodes().size(), ((ASTMethodVisitor) visitor2).getList().get(0).getNodes().size());
    }

    @Test
    public void testMethodSame() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return i;} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return j;} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertEquals(((ASTMethodVisitor) visitor1).getList().get(0).getNodes().size(), ((ASTMethodVisitor) visitor2).getList().get(0).getNodes().size());
    }

    @Test
    public void testMethodFull() {
        String testCode1 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"hello\";} \n} ";
        String testCode2 = "\n public class A {" +
                "\npublic String parse(String txt) {return \"world\";} \n} ";
        CompilationUnit cu1 = astParser.parse(testCode1);
        CompilationUnit cu2 = astParser.parse(testCode2);

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertEquals(((ASTMethodVisitor) visitor1).getList().get(0).getNodes().size(), ((ASTMethodVisitor) visitor2).getList().get(0).getNodes().size());
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

        ASTVisitor visitor1 = new ASTMethodVisitor();
        ASTVisitor visitor2 = new ASTMethodVisitor();
        cu1.accept(visitor1);
        cu2.accept(visitor2);

        assertNotEquals(((ASTMethodVisitor) visitor1).getList().get(0), ((ASTMethodVisitor) visitor2).getList().get(0));
    }

}
