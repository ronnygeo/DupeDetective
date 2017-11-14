package cs5500.project.engine.ast;

import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTStructureVisitor extends ASTVisitor {

    public ASTStructureVisitor() {
        nodes = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public boolean visit(MethodDeclaration node) {
        SimpleName name = node.getName();
        System.out.println(name);
        this.nodes.add(name.getIdentifier());
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(InfixExpression node) {
        System.out.println("In Infix");
        this.nodes.add("Infix");
        node.getLeftOperand().accept(this);
        this.nodes.add(node.getOperator().toString());
        node.getRightOperand().accept(this);
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(Expression node) {
        String name = node.toString();
        System.out.println(name);
        this.nodes.add("expression");
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(Assignment node) {
        String name = node.toString();
        System.out.println(name);
        this.nodes.add("assignment");
        node.getLeftHandSide().accept(this);
        node.getRightHandSide().accept(this);
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(PostfixExpression node) {
        String name = node.toString();
        System.out.println(name);
        this.nodes.add("postfix");
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(PrefixExpression node) {
        String name = node.toString();
        System.out.println(name);
        this.nodes.add("prefix");
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(StringLiteral node) {
        String name = node.toString();
        System.out.println(name);
        this.nodes.add("string");
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(NumberLiteral node) {
        String name = node.toString();
        this.nodes.add("number");
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(VariableDeclaration node) {
        String name = node.toString();
        this.nodes.add(node.getName().toString());
        return false; // do not continue to avoid usage info
    }

    @SuppressWarnings("unchecked")
    public boolean visit(VariableDeclarationFragment node) {
        String name = node.toString();
        this.nodes.add(node.getName().toString());
        return false; // do not continue to avoid usage info
    }

    public boolean visit(SimpleName node) {
        if (this.nodes.contains(node.getIdentifier())) {
            System.out.println(node.getIdentifier());
        }
        return true;
    }

    public boolean visit(VariableDeclarationStatement node) {
        for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
            VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter.next();
            this.nodes.add(fragment.getName().toString());
        }
        return false; // prevent that SimpleName is interpreted as reference
    }

    public List<String> getNodes() {
        return nodes;
    }

    private List<String> nodes;
    private CompilationUnit cu;
}

