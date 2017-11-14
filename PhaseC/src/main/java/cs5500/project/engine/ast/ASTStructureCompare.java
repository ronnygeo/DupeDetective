package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 *
 */
public class ASTStructureCompare implements CustomComparator<CompilationUnit> {
    /**
     * Compare the first object with the other
     *
     * @param obj1 : the first object to compare
     * @param obj2 : the second object to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public float compare(CompilationUnit obj1, CompilationUnit obj2) {
        ASTStructureVisitor astVisitor1 = new ASTStructureVisitor();
        ASTStructureVisitor astVisitor2 = new ASTStructureVisitor();
        obj1.accept(astVisitor1);
        obj1.accept(astVisitor2);
        System.out.println(astVisitor1.getList().toString());

        return 0;
    }
}
