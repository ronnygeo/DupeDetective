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

public class Clone {

	public static void main(String[] args) {
        int i = 0;
        int j = 10;
        int k = i + j;
        System.out.println("Hellooo World!");
        
        for (int ind=0; ind < 10; ind++) {
            System.out.println(ind);
            continue;
        }
    }

}
