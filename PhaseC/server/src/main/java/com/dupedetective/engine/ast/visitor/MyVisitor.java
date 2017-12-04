package com.dupedetective.engine.ast.visitor;

import com.dupedetective.engine.ast.ASTHashObject;

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
