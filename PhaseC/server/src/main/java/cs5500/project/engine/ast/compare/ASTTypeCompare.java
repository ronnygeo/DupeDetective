package cs5500.project.engine.ast.compare;

import cs5500.project.engine.CustomComparator;
import cs5500.project.data.ReportLine;
import cs5500.project.engine.ast.ASTHashObject;
import cs5500.project.engine.ast.compare.LCSCompare;

import java.util.List;
import java.util.stream.Collectors;

import static cs5500.project.engine.ast.ASTUtilities.cleanLists;
import static cs5500.project.engine.ast.ASTUtilities.createReportItems;

/**
 * AST comparator that compares the structure of the code
 */
public class ASTTypeCompare implements CustomComparator<List<ASTHashObject>> {
    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public List<ReportLine> compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        List<ASTHashObject>lcsList = lcsc.compare(l1, l2);
        float score = getScore(l1, l2);

        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);

        return createReportItems(l1, l2, score);
    }

    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    public float getScore(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        List<ASTHashObject>lcsList = lcsc.compare(l1, l2);

        float score = lcsList.size() / (float) Math.max(l1.size(), l2.size());
        if (Float.isNaN(score)) score = 0;
        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);
        System.out.println("Structure comparison");
        System.out.println("After: " + l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        System.out.println("After: " + l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));

        return score;
    }
}
