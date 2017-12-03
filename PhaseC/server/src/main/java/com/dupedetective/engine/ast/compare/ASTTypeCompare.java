package com.dupedetective.engine.ast.compare;

import com.dupedetective.engine.CustomComparator;
import com.dupedetective.data.ReportLine;
import com.dupedetective.engine.ast.ASTHashObject;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static com.dupedetective.engine.ast.ASTUtilities.cleanLists;
import static com.dupedetective.engine.ast.ASTUtilities.createReportItems;

/**
 * AST comparator that compares the structure of the code
 */
public class ASTTypeCompare implements CustomComparator<List<ASTHashObject>> {
    /*
    Logger for error or info messages
     */
    final static Logger logger = Logger.getLogger(ASTTypeCompare.class);

    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return list of report line objects
     */
    @Override
    public List<ReportLine> compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare();
        List<ASTHashObject> lcsList = lcsc.compare(l1, l2);
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
        List<ASTHashObject> lcsList = lcsc.compare(l1, l2);

        float score = lcsList.size() / (float) Math.max(l1.size(), l2.size());
        if (Float.isNaN(score)) score = 0;
        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);
        logger.info("Structure comparison");
        logger.info("After: " + l1.stream().map(ASTHashObject::getType).collect(Collectors.toList()));
        logger.info("After: " + l2.stream().map(ASTHashObject::getType).collect(Collectors.toList()));

        return score;
    }
}
