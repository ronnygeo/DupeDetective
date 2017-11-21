package cs5500.project.engine.ast;

import cs5500.project.engine.ParseVisitor;
import org.eclipse.jdt.core.dom.*;

import java.util.Iterator;

/**
 * A Copy of the Builtin ASTVisitor class with only the required methods defined as abstract
 */
public abstract class ASTVisitorAC extends ASTVisitor implements ParseVisitor {

    /**
     * Visit the given component using this visitor
     * @param node An Import Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(ImportDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node A ClassInstanceCreation
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ClassInstanceCreation node);

    /**
     * Visit the given component using this visitor
     * @param node An Tag Element
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(TagElement node);

    /**
     * Visit the given component using this visitor
     * @param node A Package Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(PackageDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node A Variable Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(VariableDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node A Modifier
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(Modifier node);

    /**
     * Visit the given component using this visitor
     * @param node A Member Reference
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(MemberRef node);

    /**
     * Visit the given component using this visitor
     * @param node A Compilation Unit
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(CompilationUnit node);

    /**
     * Visit the given component using this visitor
     * @param node A Comment
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(Comment node);

    /**
     * Visit the given component using this visitor
     * @param node A Body Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(BodyDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node An Anonymous Class Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(AnonymousClassDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node A Method Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(MethodDeclaration node);

    /**
     * Visit the given component using this visitor
     * @param node A Block
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(Block node);

    /**
     * Visit the given component using this visitor
     * @param node A Return Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ReturnStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ForStatement node);

    /**
     * Method called once the visit is complete on the given component
     * @param node A For loop Statement
     */
    public abstract void endVisit(ForStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Enhanced For loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(EnhancedForStatement node);

    /**
     * Method called once the visit is complete on the given component
     * @param node A Enhanced For loop Statement
     */
    public abstract void endVisit(EnhancedForStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(WhileStatement node);

    /**
     * Method called once the visit is complete on the given component
     * @param node A While loop Statement
     */
    public abstract void endVisit(WhileStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Do While loop Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(DoStatement node);

    /**
     * Method called once the visit is complete on the given component
     * @param node A Do while loop Statement
     */
    public abstract void endVisit(DoStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Break Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(BreakStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Continue Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ContinueStatement node);

    /**
     * Visit the given component using this visitor
     * @param node An If Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(IfStatement node);

    /**
     * Post Visit operations for the given component
     *
     * @param node An If Statement
     */
    public abstract void endVisit(IfStatement node);


    /**
     * Visit the given component using this visitor
     * @param node A Switch Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(SwitchStatement node);

    /**
     * Post Visit the given component using this visitor
     *
     * @param node A Switch Statement
     */
    public abstract void endVisit(SwitchStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(SwitchCase node);

    /**
     * Visit the given component using this visitor
     * @param node An Expression Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ExpressionStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Method Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(MethodInvocation node);

    /**
     * Visit the given component using this visitor
     * @param node An Assert Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(AssertStatement node);

    /**
     * Visit the given component using this visitor
     * @param node An Empty Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(EmptyStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Labeled Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(LabeledStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Super Constructor Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(SuperConstructorInvocation node);

    /**
     * Visit the given component using this visitor
     * @param node A Constructor Invocation
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ConstructorInvocation node);


    /**
     * Visit the given component using this visitor
     * @param node A Synchronized Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(SynchronizedStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Type Declaration Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(TypeDeclarationStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Type Declaration
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(TypeDeclaration node);


    /**
     * Visit the given component using this visitor
     * @param node A Try Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(TryStatement node);

    /**
     * Visit the given component using this visitor
     * @param node An Catch Clause
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(CatchClause node);

    /**
     * Visit the given component using this visitor
     * @param node A Throw Statement
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(ThrowStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A SimpleName
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(SimpleName node);

    /**
     * Visit the given component using this visitor
     * @param node A Variable Declaration Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(VariableDeclarationStatement node);

    /**
     * Visit the given component using this visitor
     * @param node A Variable Declaration Fragment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(VariableDeclarationFragment node);

    /**
     * Visit the given component using this visitor
     * @param node An Annotation
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(Annotation node);

    /**
     * Visit the given component using this visitor
     * @param node An Assignment
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(Assignment node);

    /**
     * Visit the given component using this visitor
     * @param node A Boolean Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(BooleanLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A CastExpression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(CastExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Switch Case Statement
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(CharacterLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A ConditionExpression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(ConditionalExpression node);

    /**
     * POST Visit the given component using this visitor
     *
     * @param node A ConditionExpression
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean postVisit(ConditionalExpression node);

    /**
     * Visit the given component using this visitor
     * @param node An Infix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(InfixExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Instanceof Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(InstanceofExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Name
     * @return a boolean whether to traverse subtrees or not
     */
    public abstract boolean visit(Name node);

    /**
     * Visit the given component using this visitor
     * @param node A NullLiteral
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(NullLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A NumberLiteral
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(NumberLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A Parenthesized Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(ParenthesizedExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Postfix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(PostfixExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Prefix Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(PrefixExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A String Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(StringLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A this Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(ThisExpression node);

    /**
     * Visit the given component using this visitor
     * @param node A Type Literal
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(TypeLiteral node);

    /**
     * Visit the given component using this visitor
     * @param node A Variable Declaration Expression
     * @return a boolean whether to traverse subtrees or not
     */
    @Override
    public abstract boolean visit(VariableDeclarationExpression node);
}
