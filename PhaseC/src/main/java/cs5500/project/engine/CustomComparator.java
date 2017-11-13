package cs5500.project.engine;

/**
 * A Custom Comparator class that can compare objects of different kinds
 * Eg: An AST parser
 * @param <T> The type of the objects to compare
 */
public interface CustomComparator<T> {

    /**
     * Compare the first object with the other
     * @param obj1: the first object to compare
     * @param obj2: the second object to compare
     * @return a value that represents how similar the two documents are
     */
    public float compare(T obj1, T obj2);

}
