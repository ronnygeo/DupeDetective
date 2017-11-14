package cs5500.project.engine.ast;

import cs5500.project.engine.ASTObject;
import cs5500.project.engine.ParseVisitor;
import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;

public class ASTStructureVisitor extends ASTVisitorAC implements ParseVisitor {

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
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
//        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Tag Element
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(TagElement node) {
        nodes.add(new ASTObject(node.getTagName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Variable Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(VariableDeclaration node) {
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getKeyword().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean postVisit(ForStatement node) {
        nodes.add(new ASTObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Enhanced For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(EnhancedForStatement node) {
        nodes.add(new ASTObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Enhanced For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean postVisit(EnhancedForStatement node) {
        nodes.add(new ASTObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(WhileStatement node) {
        nodes.add(new ASTObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean postVisit(WhileStatement node) {
        nodes.add(new ASTObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));

        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Do While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(DoStatement node) {
        nodes.add(new ASTObject("loop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Method called once the visit is complete on the given component
     *
     * @param node A Do while loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean postVisit(DoStatement node) {
        nodes.add(new ASTObject("endloop", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Break Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BreakStatement node) {
        nodes.add(new ASTObject(node.getLabel().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
//        nodes.add(new ASTObject(node.getLabel().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("cond", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Post Visit operations for the given component
     *
     * @param node An If Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean postVisit(IfStatement node) {
        nodes.add(new ASTObject("endcond", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node An Expression Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(ExpressionStatement node) {
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getMessage().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("empty", node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getLabel().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("switch", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Post Visit the given component using this visitor
     *
     * @param node A Switch Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public boolean postVisit(SwitchStatement node) {
        nodes.add(new ASTObject("endswitch", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SwitchCase node) {
        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getDeclaration().getName().getIdentifier(), node.getDeclaration().getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("try", node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getException().getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getExpression().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     *
     * @param node A SimpleName
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(SimpleName node) {
        nodes.add(new ASTObject(node.getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getName().getIdentifier(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getTypeName().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return false;
    }

    /**
     * Visit the given component using this visitor
     *
     * @param node A Boolean Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public boolean visit(BooleanLiteral node) {
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("cond", node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * POST Visit the given component using this visitor
     *
     * @param node A ConditionExpression
     * @return a boolean whether to traverse subtrees or not
     */
    public boolean postVisit(ConditionalExpression node) {
        nodes.add(new ASTObject("endcond", node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("instanceOf", node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject("block", node.getNodeType(), node.getStartPosition(), node.getLength()));

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
        nodes.add(new ASTObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getOperator().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getQualifier().getFullyQualifiedName(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
        nodes.add(new ASTObject(node.getType().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
        return true;
    }

    /**
     * Returns the list of nodes in the AST
     * @return list of nodes in AST
     */
    public List<ASTObject> getList() {
        return nodes;
    }

    private List<ASTObject> nodes;
}

