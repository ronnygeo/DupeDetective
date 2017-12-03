package com.example;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class Main {

    public static void main(String[] args) {
        int i;
        i = 0;
        int[] items = {1,2,3};
        Boolean status = false;
        ++i;
        int k = 10;
        k += 10;
        int p = i + k;
        System.out.println("Hellooo World!");
        for (int item: items) {
            System.out.println(item);
        }
        int t = 0;
        while(t < 10) {
            System.out.println(t);
            t++;
        }
    }

}
