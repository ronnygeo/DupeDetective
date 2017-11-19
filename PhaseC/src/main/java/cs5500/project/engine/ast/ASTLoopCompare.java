package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Compare two lists of ASTHashObjects
 */
public class ASTLoopCompare implements CustomComparator<List<ASTHashObject>> {
    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public float compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        float sum = 0;
        float count = 0;


        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                if (i == j) {
                    float val = compareNodes(l1.get(i).getNodes(), l2.get(j).getNodes());
                    System.out.println(val);
                    sum += val;
                    count++;
                }
            }
        }
        return sum;
    }

    /**
     * Compares the list of nodes within the current node
     * @param l1 the list of nodes
     * @param l2 the list of ndoes
     * @return the lcs of given lists
     */
    private float compareNodes(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        System.out.println("l1: " + l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println("l2" + l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        return lcsc.compare(l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()),
                l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
    }
}
