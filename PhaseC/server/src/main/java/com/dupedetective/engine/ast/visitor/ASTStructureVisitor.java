package com.dupedetective.engine.ast.visitor;

import com.dupedetective.engine.ast.ASTHashObject;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;

/**
 * AST visitor that visits nodes and keeps a list of node types
 */
public class ASTStructureVisitor extends ASTVisitorAC {

    /**
     * Default constructor
     */
    public ASTStructureVisitor() {
        nodes = new ArrayList<>();
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Package Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(PackageDeclaration node) {
        nodes.add(new ASTHashObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Import Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ImportDeclaration node) {
        nodes.add(new ASTHashObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A ClassInstanceCreation
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ClassInstanceCreation node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));

        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Modifier
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Modifier node) {
        nodes.add(new ASTHashObject(node.getKeyword().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Compilation Unit
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(CompilationUnit node) {
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Method Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(MethodDeclaration node) {
        nodes.add(new ASTHashObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Block
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Block node) {
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Return Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ReturnStatement node) {
        nodes.add(new ASTHashObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ForStatement node) {
        nodes.add(new ASTHashObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A For loop Statement
     */
    @Override
    public void endVisit(ForStatement node) {
        nodes.add(new ASTHashObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Enhanced For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(EnhancedForStatement node) {
        nodes.add(new ASTHashObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Enhanced For loop Statement
     */
    @Override
    public void endVisit(EnhancedForStatement node) {
        nodes.add(new ASTHashObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(WhileStatement node) {
        nodes.add(new ASTHashObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A While loop Statement
     */
    @Override
    public void endVisit(WhileStatement node) {
        nodes.add(new ASTHashObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Do While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(DoStatement node) {
        nodes.add(new ASTHashObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Do while loop Statement
     */
    @Override
    public void endVisit(DoStatement node) {
        nodes.add(new ASTHashObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Break Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BreakStatement node) {
        nodes.add(new ASTHashObject("break", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Continue Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ContinueStatement node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An If Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(IfStatement node) {
        nodes.add(new ASTHashObject("cond", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Post Visit operations for the given component
     *
     * @param node An If Statement
     */
    @Override
    public void endVisit(IfStatement node) {
        nodes.add(new ASTHashObject("endcond", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Expression Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ExpressionStatement node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Method Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(MethodInvocation node) {
        nodes.add(new ASTHashObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Super Constructor Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SuperConstructorInvocation node) {
        nodes.add(new ASTHashObject("super", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Constructor Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ConstructorInvocation node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Switch Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SwitchStatement node) {
        nodes.add(new ASTHashObject("switch", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Post Visit the given component using this visitor
     *
     * @param node A Switch Statement
     */
    public void endVisit(SwitchStatement node) {
        nodes.add(new ASTHashObject("endswitch", node.getNodeType(), node.getStartPosition(), node.getLength()));
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SwitchCase node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Type Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TypeDeclaration node) {
        nodes.add(new ASTHashObject(node.getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Try Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TryStatement node) {
        nodes.add(new ASTHashObject("try", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Catch Clause
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(CatchClause node) {
        nodes.add(new ASTHashObject(node.getException().getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Throw Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ThrowStatement node) {
        nodes.add(new ASTHashObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     *
     * @param node A SimpleName
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SimpleName node) {
        nodes.add(new ASTHashObject(node.getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(VariableDeclarationStatement node) {
        nodes.add(new ASTHashObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration Fragment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(VariableDeclarationFragment node) {
        nodes.add(new ASTHashObject(node.getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Assignment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Assignment node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Boolean Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BooleanLiteral node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A CastExpression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(CastExpression node) {
        nodes.add(new ASTHashObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(CharacterLiteral node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A ConditionExpression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ConditionalExpression node) {
        nodes.add(new ASTHashObject("cond", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * POST Visit the given component using this visitor
     *
     * @param node A ConditionExpression
     */
    @Override
    public void endVisit(ConditionalExpression node) {

    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Infix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(InfixExpression node) {
        nodes.add(new ASTHashObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Instanceof Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(InstanceofExpression node) {
        nodes.add(new ASTHashObject("instanceOf", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A NullLiteral
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(NullLiteral node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A NumberLiteral
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(NumberLiteral node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Parenthesized Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ParenthesizedExpression node) {
        nodes.add(new ASTHashObject("block", node.getNodeType(), node.getStartPosition(), node.getLength()));

        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Postfix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(PostfixExpression node) {
        nodes.add(new ASTHashObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Prefix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(PrefixExpression node) {
        nodes.add(new ASTHashObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A String Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(StringLiteral node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A this Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ThisExpression node) {
        nodes.add(new ASTHashObject("this", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(VariableDeclarationExpression node) {
        nodes.add(new ASTHashObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Field Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(FieldDeclaration node) {
        nodes.add(new ASTHashObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Initializer
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Initializer node) {
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ArrayInitializer node) {
        nodes.add(new ASTHashObject(node.expressions().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ArrayCreation node) {
        nodes.add(new ASTHashObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }


    /**
     * Returns the list of nodes in the AST
     * @return list of nodes in AST
     */
    public List<ASTHashObject> getList() {
        return nodes;
    }

    private List<ASTHashObject> nodes;
}

