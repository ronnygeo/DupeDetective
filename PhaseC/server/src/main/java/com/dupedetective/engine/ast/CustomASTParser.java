package com.dupedetective.engine.ast;

import com.dupedetective.engine.Parser;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * AST Parser that creates the AST compilation unit from the code
 */
public class CustomASTParser implements Parser<CompilationUnit> {

    /**
     * Default Constructor
     */
    public CustomASTParser() { }

    /**
     * Parse the given String into type T
     * @return the parsed AST Tree
     */
    public CompilationUnit parse(String txt) {
        if (txt == null) txt = "";
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(txt.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        return (CompilationUnit) parser.createAST(null);
    }
}
