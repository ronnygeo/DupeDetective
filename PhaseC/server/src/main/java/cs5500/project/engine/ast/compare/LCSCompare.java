package cs5500.project.engine.ast.compare;

import cs5500.project.engine.ast.ASTHashObject;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.ListUtils;

import java.util.List;
import java.util.Objects;

/**
 * Compare two lists using LCS algorithm
 */
public class LCSCompare {

    private LCSCompareMode mode;

    /**
     * Specify the field to use for LCS
     * @param mode LCSCompareMode enum
     */
    public LCSCompare(LCSCompareMode mode) {
        this.mode = mode;
    }

    /**
     * Default constructor initializes compare mode to type
     */
    public LCSCompare() {
        this.mode = LCSCompareMode.TYPE;
    }

    /**
     * Compare the first object with the other
     *
     * @param obj1 : the first object to compare
     * @param obj2 : the second object to compare
     * @return a value that represents how similar the two documents are
     */
    public List<ASTHashObject> compare(List<ASTHashObject> obj1, List<ASTHashObject> obj2) {
        if (mode == LCSCompareMode.HASH) return (ListUtils.longestCommonSubsequence(obj1, obj2, new LCSHashEquator()));
        else return (ListUtils.longestCommonSubsequence(obj1, obj2, new LCSTypeEquator()));
    }

    /**
     * Get the hash value of the object
     * @param a An AST Hash Object
     * @return the hash value of the object
     */
    public Integer getHash(ASTHashObject a) {
        LCSTypeEquator typeEquator = new LCSTypeEquator();
        LCSHashEquator hashEquator = new LCSHashEquator();
        if (mode == LCSCompareMode.HASH) return hashEquator.hash(a);
        else return typeEquator.hash(a);
    }


    /**
     * Run LCS with the type of the node
     */
    class LCSTypeEquator implements Equator<ASTHashObject> {
        /**
         * @param t1 the first object to compare
         * @param t2 the second object to compare
         * @return whether the two objects are equal or not
         */
        @Override
        public boolean equate(ASTHashObject t1, ASTHashObject t2) {
            return Objects.equals(t1.getType(), t2.getType());
        }

        /**
         * @param o the AST Hash Object
         * @return the hashcode of the node
         */
        @Override
        public int hash(ASTHashObject o) {
            return o.hashCode();
        }
    }

    /**
     * Run LCS with the hash of the node
     */
    class LCSHashEquator implements Equator<ASTHashObject> {
        /**
         * @param t1 the first object to compare
         * @param t2 the second object to compare
         * @return whether the two objects are equal or not
         */
        @Override
        public boolean equate(ASTHashObject t1, ASTHashObject t2) {
            return Objects.equals(t1.getHash(), t2.getHash());
        }

        /**
         * @param o the AST Hash Object
         * @return the hashcode of the node
         */
        @Override
        public int hash(ASTHashObject o) {
            return o.hashCode();
        }
    }
}
