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
        System.out.println("Before: " + l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println("Before: " + l2);
        System.out.println("Before: " + l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        List<ASTHashObject>lcsList = lcsc.compare(l1, l2);

        float score = lcsList.size() / (float) Math.max(l1.size(), l2.size());
        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);

        System.out.println("LCS: " + lcsList.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println("After: " + l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println("After: " + l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));

        return score;
    }

    /**
     * Remove the nodes not in LCS from the given list
     * @param l the list to clean
     * @param lcsList the list with LCS nodes
     * @return new list with only the LCS nodes as objects
     */
    private void cleanLists(List<ASTHashObject> l, List<ASTHashObject> lcsList) {
        int tmpIndex = 0;
        //Store the similar nodes in the reportItem object
        for (int i=0; i < lcsList.size(); i++) {
            boolean found = false;

            while (!found) {
                if ((long) l.get(tmpIndex).getType() == lcsList.get(i).getType()) {
                    found = true;
                    tmpIndex++;
                } else {
                    l.remove(tmpIndex);
                }
            }
        }
    }
}
