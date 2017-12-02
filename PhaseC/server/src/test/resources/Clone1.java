package com.example;

import java.util.HashSet;
import java.util.Set;
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
        int k;
        k = 10;
        int p = i + k;
        System.out.println("Hellooo World!");
        
        t = 0;
        while(t < 10) {
            System.out.println(t);
            t++;
        }
    }

}
