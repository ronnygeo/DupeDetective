package cs5500.project.engine.ast;

import cs5500.project.engine.ASTObject;
import org.eclipse.jdt.core.dom.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestAST2 {

    public static void main(String[] args) {

        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(("public class A { public void doSomething() { ArrayList<Integer> al = new ArrayList<Integer>(); }}").toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {

            Set names = new HashSet();

            @Override
            public boolean visit(ImportDeclaration node) {
                System.out.println(node.getName().getFullyQualifiedName() + " " + node.getNodeType() + " " + node.getStartPosition()+ " " +node.getLength());
                return false; // do not continue to avoid usage info
            }


            /**
             * Visit the given component using this visitor
             *
             * @param node A Variable Declaration Expression
             * @return a boolean whether to traverse subtrees or not
             */
            @Override
            public boolean visit(ArrayInitializer node) {
//                nodes.add(new ASTObject(node.expressions().toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
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
//                nodes.add(new ASTObject(node.toString(), node.getNodeType(), node.getStartPosition(), node.getLength()));
                return true;
            }

            public boolean visit(ClassInstanceCreation node) {
                System.out.println(node.arguments());

                return false; // do not continue to avoid usage info
            }

            public boolean visit(TagElement node) {
                System.out.println(node.getTagName());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(PackageDeclaration node) {
                System.out.println(node.getName());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(VariableDeclaration node) {
                System.out.println(node.getName());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(Modifier node) {
//                System.out.println(node.getKeyword());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(MemberRef node) {
                System.out.println(node);
                return true; // do not continue to avoid usage info
            }

            public boolean preVisit(CompilationUnit node) {
                System.out.println(node.imports());
                return true; // do not continue to avoid usage info
            }

            public boolean postVisit(CompilationUnit node) {
//                System.out.println(node.imports());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(CompilationUnit node) {
//                System.out.println(node.imports());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(Comment node) {
                System.out.println(node.toString());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(CatchClause node) {
                System.out.println(node.getBody());
                System.out.println(node.getException());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(BodyDeclaration node) {
                System.out.println(node.getModifiers());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(AnonymousClassDeclaration node) {
                System.out.println(node.bodyDeclarations());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(MethodDeclaration node) {
                SimpleName name = node.getName();
//                System.out.println(name + " returns "+ node.getBody().statements());
                this.names.add(name.getIdentifier());
                System.out.println("Declaration of method '"+name+"' at line "+cu.getLineNumber(name.getStartPosition()) + " returns " + node.getReturnType2());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(Block node) {
                System.out.println("Visiting block ");
                return true; // do not continue to avoid usage info
            }


            public boolean visit(ReturnStatement node) {
                System.out.println("returning: " + node.getExpression());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(ForStatement node) {
                System.out.println(node.getParent());
                System.out.println(node.getBody());
                System.out.println(node.getExpression());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(Statement node) {
                return true; // do not continue to avoid usage info
            }

            public boolean visit(EnhancedForStatement node) {
                System.out.println(node.getExpression());
                System.out.println(node.getBody());

                return true; // do not continue to avoid usage info
            }

//            public boolean preVisit(IfStatement node) {
//                System.out.println("Going into If");
//                return true;
//            }

            public void endVisit(IfStatement node) {
                System.out.println("getting out of if");
            }

            public boolean visit(IfStatement node) {
//                System.out.println("If statement: " + node);
                System.out.println(node.getExpression());
                System.out.println(node.getThenStatement().getNodeType());
                System.out.println(node.getElseStatement().getNodeType());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(ExpressionStatement node) {
                System.out.println(node.getExpression());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(MethodInvocation node) {
                System.out.println(node.getExpression());
                System.out.println(node.getName());
                System.out.println(node.arguments());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(AssertStatement node) {
                System.out.println(node.getExpression());
                System.out.println(node.getMessage());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(BreakStatement node) {
                System.out.println(node.getLabel());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(ContinueStatement node) {
                System.out.println(node.getLabel());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(DoStatement node) {
                System.out.println(node.getExpression());
                System.out.println(node.getBody());
                return true; // do not continue to avoid usage info
            }
            public boolean visit(EmptyStatement node) {
                System.out.println("empty");
                return false; // do not continue to avoid usage info
            }
            public boolean visit(LabeledStatement node) {
                System.out.println(node.getBody());
                System.out.println(node.getLabel());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(SuperConstructorInvocation node) {
                System.out.println(node.getExpression());
                System.out.println(node.arguments());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(ConstructorInvocation node) {
                System.out.println(node.arguments());
                return false; // do not continue to avoid usage info
            }

            public boolean visit(SwitchCase node) {
                System.out.println(node.getExpression());
                System.out.println(node.isDefault());
                return true; // do not continue to avoid usage info
            }
            public boolean visit(SwitchStatement node) {
                System.out.println(node.getExpression());
                System.out.println(node.statements());
                return true; // do not continue to avoid usage info
            }
            public boolean visit(SynchronizedStatement node) {
                System.out.println(node.getExpression());
                return true; // do not continue to avoid usage info
            }
            public boolean visit(TypeDeclarationStatement node) {
                System.out.println(node.getDeclaration());
                return true; // do not continue to avoid usage info
            }
            public boolean visit(TypeDeclaration node) {
                System.out.println(node.getName().getIdentifier());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(TryStatement node) {
                System.out.println(node.getBody());
                System.out.println(node.getFinally());
                System.out.println(node.catchClauses());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(ThrowStatement node) {
                System.out.println(node.getExpression());
                return false; // do not continue to avoid usage info
            }
            public boolean visit(WhileStatement node) {
                System.out.println(node.getExpression());
                return true; // do not continue to avoid usage info
            }


            @Override
            public boolean visit(SimpleName node) {
//                if (this.names.contains(node.getIdentifier())) {
//                    System.out.println("Usage of '" + node + "' at line " +	cu.getLineNumber(node.getStartPosition()));
//                }
                return true;
            }

            @Override
            public boolean visit(VariableDeclarationStatement node) {
                for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
                    VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter.next();
                    System.out.println(fragment.getName().toString());
//                    this.names.add(fragment.getName().toString());
                }
                return true; // prevent that SimpleName is interpreted as reference
            }

            @Override
            public boolean visit(VariableDeclarationFragment node) {
                SimpleName name = node.getName();
                this.names.add(name.getIdentifier());
                System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));
                return false; // do not continue to avoid usage info
            }

            public boolean visit(Annotation node) {
                String name = node.getTypeName().getFullyQualifiedName();
                System.out.println("Annotation " + name);
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(Assignment node) {
                System.out.println("Assignment");
                System.out.println(node.getLeftHandSide());
                System.out.println(node.getRightHandSide());
                System.out.println(node.getOperator());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(BooleanLiteral node) {
                Boolean name = node.booleanValue();
//                System.out.println(name);
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(CastExpression node) {
                System.out.println(node.getExpression());
                System.out.println(node.getType());
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(CharacterLiteral node) {
//                System.out.println(node.charValue());
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(ConditionalExpression node) {
                System.out.println("condexp");
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(InfixExpression node) {
                System.out.println(node.getLeftOperand());
                System.out.println(node.getRightOperand());
                System.out.println(node.getOperator());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(InstanceofExpression node) {
                System.out.println(node.getLeftOperand());
                System.out.println(node.getRightOperand());
                return true; // do not continue to avoid usage info
            }

            public boolean visit(Name node) {
                System.out.println(node.getFullyQualifiedName());
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(NullLiteral node) {
//                System.out.println("null");
               return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(NumberLiteral node) {
//                System.out.println(node.getToken());
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(ParenthesizedExpression node) {
                System.out.println(node.getExpression());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(PostfixExpression node) {
                System.out.println(node.getOperand());
                System.out.println(node.getOperator());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(PrefixExpression node) {
                System.out.println(node.getOperand());
                System.out.println(node.getOperator());
                return true; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(StringLiteral node) {
//                System.out.println(node.getLiteralValue());
                return false; // do not continue to avoid usage info
            }

            @Override
            public boolean visit(ThisExpression node) {
                System.out.println(node.getQualifier());
                return false; // do not continue to avoid usage info
            }
            @Override
            public boolean visit(TypeLiteral node) {
//                System.out.println(node.getType());
                return false; // do not continue to avoid usage info
            }
            @Override
            public boolean visit(VariableDeclarationExpression node) {
                System.out.println(node.fragments());
                System.out.println(node.getType());
                return false; // do not continue to avoid usage info
            }

        });
    }

}

