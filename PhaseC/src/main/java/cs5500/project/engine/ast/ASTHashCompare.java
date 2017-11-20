package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class ASTHashCompare implements CustomComparator<CompilationUnit> {
    /**
     * Compare the first object with the other
     *
     * @param obj1 : the first object to compare
     * @param obj2 : the second object to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public float compare(CompilationUnit obj1, CompilationUnit obj2) {
        ASTVisitor astVisitor1 = new ASTStructureVisitor();
        ASTVisitor astVisitor2 = new ASTStructureVisitor();
        obj1.accept(astVisitor1);
        obj2.accept(astVisitor2);

        List<ASTHashObject> l1 = ((ASTStructureVisitor)astVisitor1).getList();
        List<ASTHashObject> l2 = ((ASTStructureVisitor)astVisitor2).getList();

        HashCompare hc = new HashCompare();
        System.out.println(l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println(l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        return hc.compare(l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()),
                l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
    }
}
