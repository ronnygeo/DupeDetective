package cs5500.project.engine.ast;

import cs5500.project.data.ReportLine;
import cs5500.project.engine.CustomComparator;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static cs5500.project.engine.ast.ASTUtilities.cleanLists;
import static cs5500.project.engine.ast.ASTUtilities.createReportItems;

/**
 * Class that compares the hashes inside the AST
 */
public class ASTHashCompare implements CustomComparator<List<ASTHashObject>> {
    /*
    Logger for error or info messages
     */
    final static Logger logger = Logger.getLogger(ASTHashCompare.class);
    /**
     * Compare the first object with the other
     *
     * @param l1 : the first list to compare
     * @param l2 : the second list to compare
     * @return a value that represents how similar the two documents are
     */
    @Override
    public List<ReportLine> compare(List<ASTHashObject> l1, List<ASTHashObject> l2) {
        LCSCompare lcsc = new LCSCompare(LCSCompareMode.TYPE);
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
        LCSCompare lcsc = new LCSCompare(LCSCompareMode.TYPE);
        List<ASTHashObject>lcsList = lcsc.compare(l1, l2);

        float score = lcsList.size() / ((float) Math.max(l1.size(), l2.size()));
        if (Float.isNaN(score)) score = 0;
        cleanLists(l1, lcsList);
        cleanLists(l2, lcsList);

        logger.info("Method comparison");
        logger.info("After: " + l1.stream().map(ASTHashObject::getHash).collect(Collectors.toList()));
        logger.info("After: " + l2.stream().map(ASTHashObject::getHash).collect(Collectors.toList()));

        return score;
    }
}
