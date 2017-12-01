package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import cs5500.project.data.ReportLine;

import java.util.ArrayList;
import java.util.List;

import static cs5500.project.engine.ast.ASTUtilities.cleanLists;
import static cs5500.project.engine.ast.ASTUtilities.createReportItems;

/**
 * Compare the child nodes of two lists of ASTHashObjects
 */
public class ASTParentCompare implements CustomComparator<List<ASTHashObject>> {

    private static final float SCORE_THRESHOLD = 0.3f;

    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public List<ReportLine> compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        List<ReportLine> items = new ArrayList<>();

        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                    float score = getScore(l1.get(i).getNodes(), l2.get(j).getNodes());
                    if (i == j || score > SCORE_THRESHOLD) {
                        items.addAll(compareNodes(l1.get(i).getNodes(), l2.get(j).getNodes(), score));
                    }
                }
            }
        return items;
    }

    /**
     * Compares the list of nodes within the current node
     * @param l1 the list of nodes
     * @param l2 the list of ndoes
     * @return the lcs of given lists
     */
    private List<ReportLine> compareNodes(List<ASTHashObject> l1, List<ASTHashObject> l2, float score) {
        LCSCompare lcsc = new LCSCompare();
        List<ASTHashObject> lcsList = lcsc.compare(l1, l2);

        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);

        return createReportItems(l1, l2, score);
    }

    /**
     * Compares the list of nodes within the current node
     * @param l1 the list of nodes
     * @param l2 the list of ndoes
     * @return the lcs of given lists
     */
    public float getScore(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        List<ASTHashObject>lcsList = lcsc.compare(l1, l2);

        float score = lcsList.size() / ((float) Math.max(l1.size(), l2.size()));
        if (Float.isNaN(score)) score = 0;
        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);

        return score;
    }

    /**
     * Compare the first object with the other when the AST will have child nodes
     *
     * @param l1 : the first list of parent AST nodes to compare
     * @param l2 : the second list parent AST nodes to compare
     * @return a value that represents how similar the two documents are
     */
    public float getScoreParent(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        float max = 0;

        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                float sum = 0;
                if (i == j) {
                    float val = getScore(l1.get(i).getNodes(), l2.get(j).getNodes());
                    sum += val;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
