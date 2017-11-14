package cs5500.project.engine.ast;

import org.eclipse.jdt.core.dom.*;

import java.util.HashSet;
import java.util.Set;

public class ASTStructureVisitor extends ASTVisitor {

    public ASTStructureVisitor() {
        nodes = new HashSet();
    }

    @SuppressWarnings("unchecked")
    public boolean visit(VariableDeclarationFragment node) {
        SimpleName name = node.getName();
        System.out.println(node.propertyDescriptors(AST.JLS3));
        this.nodes.add(name.getIdentifier());
        System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(InfixExpression node) {
        System.out.println(node.propertyDescriptors(AST.JLS3).toString());
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(Expression node) {
        String name = node.toString();
        this.nodes.add(name);
        return false; // do not continue to avoid usage info
    }

    public boolean visit(SimpleName node) {
        if (this.nodes.contains(node.getIdentifier())) {
            System.out.println("Usage of '" + node + "' at line " +	cu.getLineNumber(node.getStartPosition()));
        }
        return true;
    }


    public Set getNodes() {
        return nodes;
    }

    private Set nodes;
    private CompilationUnit cu;
}

