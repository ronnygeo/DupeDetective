package cs5500.project.engine.ast.visitor;

import cs5500.project.engine.ast.ASTHashObject;
import java.util.List;

/**
 * Interface that defines a getList() function
 */
public interface MyVisitor {
    /**
     * Returns the list of nodes in the AST
     * @return list of nodes in AST
     */
    List<ASTHashObject> getList();
}
