package cs5500.project.engine.ast;

import com.google.common.hash.HashCode;
import cs5500.project.engine.ParseVisitor;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AST Visitor implementation that visits methods
 */
public class ASTMethodVisitor extends ASTVisitorAC implements ParseVisitor {

    /**
     * Default constructor
     */
    public ASTMethodVisitor() {
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
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Import Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ImportDeclaration node) {
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
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Tag Element
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TagElement node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A SimpleType
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SimpleType node) {
        typeCheck = true;
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A SimpleType
     */
    @Override
    public void endVisit(SimpleType node) {
        typeCheck = false;
    }


    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(VariableDeclaration node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Modifier
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Modifier node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Member Reference
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(MemberRef node) {
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
     * @param node A Comment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Comment node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Body Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BodyDeclaration node) {
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Anonymous Class Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(AnonymousClassDeclaration node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Method Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(MethodDeclaration node) {
        System.out.println("Start method");
        currentNode = new ASTHashObject(node.getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength());
        System.out.println(node.getReturnType2());
        return true;
    }

    /**
     * Post Visit the method declaration, add it to the node list
     *
     * @param node A Method Declaration
     */
    @Override
    public void endVisit(MethodDeclaration node) {
        nodes.add(currentNode);
        System.out.println("End method invocation");
        resetCurrentNode();
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
        addHashToCurrentNode("return".hashCode());
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ForStatement node) {
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A For loop Statement
     */
    @Override
    public void endVisit(ForStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Enhanced For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(EnhancedForStatement node) {
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Enhanced For loop Statement
     */
    @Override
    public void endVisit(EnhancedForStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(WhileStatement node) {
//        addHashToCurrentNode(node);
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A While loop Statement
     */
    @Override
    public void endVisit(WhileStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Do While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(DoStatement node) {
//        addHashToCurrentNode(node);
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Do while loop Statement
     */
    @Override
    public void endVisit(DoStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Break Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BreakStatement node) {
        addHashToCurrentNode(node.getLabel().hashCode());
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
        addNodeToCurrentNode(node.getLabel());
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
//        addHashToCurrentNode(node);
        return true;
    }

    /**
     * Post Visit operations for the given component
     *
     * @param node An If Statement
     */
    @Override
    public void endVisit(IfStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Expression Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ExpressionStatement node) {
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
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Assert Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(AssertStatement node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Empty Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(EmptyStatement node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Labeled Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(LabeledStatement node) {
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
        return true;
    }

    /**
     * Post Visit the given component using this visitor
     *
     * @param node A Switch Statement
     */
    public void endVisit(SwitchStatement node) {
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SwitchCase node) {
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Synchronized Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SynchronizedStatement node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Type Declaration Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TypeDeclarationStatement node) {
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
        return false;
    }

    /**
     *
     * @param node A SimpleName
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SimpleName node) {
        if (typeCheck) {
            addHashToCurrentNode(node.getIdentifier().hashCode());
            typeCheck = false;
        }
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
        addHashToCurrentNode(node.getType().hashCode());
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
        addHashToCurrentNode(node.hashCode());
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Annotation
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Annotation node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Assignment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Assignment node) {
        System.out.println("Assignment");
        addHashToCurrentNode(node.getRightHandSide().hashCode());
        addHashToCurrentNode(node.getOperator().hashCode());
        addHashToCurrentNode(2 * node.getLeftHandSide().hashCode());
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
        addHashToCurrentNode("bool".hashCode());
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
        addHashToCurrentNode("char".hashCode());
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
        return true;
    }

    /**
     * POST Visit the given component using this visitor
     *
     * @param node A ConditionExpression
     * @return a boolean whether to traverse subtrees or not
     */
    public boolean postVisit(ConditionalExpression node) {
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Infix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(InfixExpression node) {
        addNodeToCurrentNode(node.getRightOperand());
        addHashToCurrentNode(node.getOperator().hashCode());
        addHashToCurrentNode(2 * node.getLeftOperand().hashCode());
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
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Name
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(Name node) {
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
        addHashToCurrentNode("null".hashCode());
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
        addHashToCurrentNode("number".hashCode());
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
        addHashToCurrentNode("string".hashCode());
        return false;
    }

    /**
     * Visit the given component using this visitor
     * @param node A this Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ThisExpression node) {
        addHashToCurrentNode("this".hashCode());
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Type Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TypeLiteral node) {
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
        return true;
    }

    /**
     * Add the hash value of a node to the current node
     * @param hash the hash value of a node
     */
    private void addHashToCurrentNode(Integer hash) {
        if (currentNode != null) currentNode.addToHash(hash);
    }

    /**
     * Add the given node to list of nodes of current node
     * @param node an AST node
     */
    private void addNodeToCurrentNode(ASTNode node) {
        if (currentNode != null) currentNode.addToHash(node.hashCode());
    }

    /**
     * Reset the current node
     */
    private void resetCurrentNode() {
        currentNode = null;
    }



    /**
     * Returns the list of nodes in the AST
     * @return list of nodes in AST
     */
    public List<ASTHashObject> getList() {
        return nodes;
    }

    private ASTHashObject currentNode;
    private List<ASTHashObject> nodes;
    private boolean typeCheck = false;
}

