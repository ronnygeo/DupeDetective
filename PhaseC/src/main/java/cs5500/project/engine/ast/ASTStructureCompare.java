package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AST comparator that compares the structure of the code
 */
public class ASTStructureCompare implements CustomComparator<List<ASTHashObject>> {
    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public float compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        System.out.println(l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println(l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        return lcsc.compare(l1.stream().map(ASTHashObject::getType).map(item -> ((long) item)).collect(Collectors.toList()),
                l2.stream().map(ASTHashObject::getType).map(item -> ((long) item)).collect(Collectors.toList())) / (float) Math.max(l1.size(), l2.size());
    }
}
