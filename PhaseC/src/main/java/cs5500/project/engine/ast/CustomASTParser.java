package cs5500.project.engine.ast;

import cs5500.project.engine.Parser;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 *
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
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(txt.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        return cu;
    }

    /**
     * @return
     */
    public String getTxt() {
        return txt;
    }

    /**
     * @param txt
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }

    private String txt;
}
