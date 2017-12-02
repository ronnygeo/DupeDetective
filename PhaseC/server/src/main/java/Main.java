package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        int t = 0;
        do {
            List<Integer> i = new ArrayList<>();
            i.add(0);
            i.add(1);
            i.add(i.get(0) + i.get(1));
            System.out.println(i.get(2) + " some numbr!");
            t++;
        } while (t < 10);
    }

}
