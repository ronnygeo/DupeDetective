package com.dupedetective.engine.ast;

import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * AST Utilities to help AST operations
 */
public class ASTUtilities {

    /**
     * Remove the nodes not in LCS from the given list
     * @param l the list to clean
     * @param lcsList the list with LCS nodes
     */
    public static void cleanLists(List<ASTHashObject> l, List<ASTHashObject> lcsList) {
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
        while (l.size() > lcsList.size()) l.remove(lcsList.size());
    }

    /**
     * Creates ReportLine objects from the two provided lists
     * @param l1 the first list
     * @param l2 the second list
     * @param score the score of comparison
     * @return a list of ReportItems from the given list
     */
    public static List<ReportLine> createReportItems(List<ASTHashObject> l1, List<ASTHashObject> l2, Float score) {
        List<ReportLine> items = new ArrayList<>();
        for (int i=0; i < l1.size(); i++) {
            ASTHashObject tmp1 = l1.get(i);
            ASTHashObject tmp2 = l2.get(i);

            ReportLine ri = new ReportLine(tmp1.getOffset(), tmp1.getLength(), tmp2.getOffset(), tmp2.getLength(), Model.ASTStructure.getValue(), score);
            items.add(ri);
        }
        return items;
    }
}
