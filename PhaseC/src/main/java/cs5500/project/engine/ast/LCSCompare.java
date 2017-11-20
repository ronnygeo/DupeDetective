package cs5500.project.engine.ast;

import cs5500.project.engine.CustomComparator;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * Compare two lists using LCS algorithm
 */
public class LCSCompare implements CustomComparator<List<Integer>> {

    /**
     * Compare the first object with the other
     *
     * @param obj1 : the first object to compare
     * @param obj2 : the second object to compare
     * @return a value that represents how similar the two documents are
     */
    public float compare(List<Integer> obj1, List<Integer> obj2) {
        return (ListUtils.longestCommonSubsequence(obj1, obj2).size() /(float) Math.max(obj1.size(), obj2.size()));
    }
}
