package cs5500.project.engine;

/**
 * A generic iterator interface
 * @param <T> the type of the underlying elements
 */
public interface Iterator<T> {

    /**
     * Check if there are more elements
      * */
    public boolean hasNext();

    /**
     * Return the next element from the underlying object
     * */
    public T next();

    /**
     * Removes from the underlying object, the last element returned by the iterator
     */
    public boolean remove();
}
