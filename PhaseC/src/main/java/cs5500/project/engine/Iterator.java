package cs5500.project.engine;

/**
 * A generic iterator interface
 * @param <T> the type of the underlying elements
 */
public interface Iterator<T> {

    /**
     * Check if there are more elements
     * @return if there is a next element or not
      * */
    public boolean hasNext();

    /**
     * Return the next element from the underlying object
     * @return T
     * */
    public T next();

    /**
     * Removes from the underlying object, the last element returned by the iterator
     * @return result of remove
     */
    public boolean remove();
}
