package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import cs5500.project.spring.data.ReportItem;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cs5500.project.engine.ast.ASTUtilities.cleanLists;

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
    public List<ReportItem> compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        float sum = 0;
        float sum_prev = 0;
        float sum_next = 0;
        float count = 0;

        List<ReportItem> items = new ArrayList<>();

        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                if (i == j) {
                    items.addAll(compareNodes(l1.get(i).getNodes(), l2.get(j).getNodes()));
                } else if (i == j + 1) {
                    items.addAll(compareNodes(l1.get(i).getNodes(), l2.get(j).getNodes()));
                } else if (i + 1 == j) {
                    items.addAll(compareNodes(l1.get(i).getNodes(), l2.get(j).getNodes()));
                }
            }
        }
        //TODO: construct ReportItem
        return items;
    }

    /**
     * Compares the list of nodes within the current node
     * @param l1 the list of nodes
     * @param l2 the list of ndoes
     * @return the lcs of given lists
     */
    private List<ReportItem> compareNodes(List<ASTHashObject> l1, List<ASTHashObject> l2) {
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

        return null;
    }

    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    public float getScore(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        float sum = 0;
        float sum_prev = 0;
        float sum_next = 0;
        float count = 0;

        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                if (i == j) {
                    float val = getScoreNodes(l1.get(i).getNodes(), l2.get(j).getNodes());
                    System.out.println(val);
                    sum += val;
                    count++;
                } else if (i == j + 1) {
                    float val = getScoreNodes(l1.get(i).getNodes(), l2.get(j).getNodes());
                    sum_prev += val;
                    count++;
                } else if (i + 1 == j) {
                    float val = getScoreNodes(l1.get(i).getNodes(), l2.get(j).getNodes());
                    sum_next += val;
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
    private float getScoreNodes(List<ASTHashObject> l1, List<ASTHashObject> l2) {
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
}
