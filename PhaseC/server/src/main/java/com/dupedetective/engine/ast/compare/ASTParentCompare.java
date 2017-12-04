package com.dupedetective.engine.ast.compare;

import com.dupedetective.engine.CustomComparator;
import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.ast.ASTHashObject;

import java.util.ArrayList;
import java.util.List;

import static com.dupedetective.engine.ast.ASTUtilities.cleanLists;
import static com.dupedetective.engine.ast.ASTUtilities.createReportItems;

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
     * @return list of report line objects
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
     * @return the similarity score
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
        Integer count = 0;

        for (int i = 0; i < l1.size(); i++) {
            for (int j=0; j < l2.size(); j++) {
                float sum = 0;
                float val = getScore(l1.get(i).getNodes(), l2.get(j).getNodes());
                if (i == j || val > SCORE_THRESHOLD) {
                    sum += val;
                    count++;
                }
                max += sum;
            }
        }
        return (count > 0)? max/count: 0;
    }
}
