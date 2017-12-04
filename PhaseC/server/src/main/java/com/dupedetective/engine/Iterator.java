package com.dupedetective.engine;

/**
 * A generic iterator interface
 * @param <T> the type of the underlying elements
 */
public interface Iterator<T> {

    /**
     * Check if there are more elements
     * @return if there is a next element or not
      * */
    boolean hasNext();

    /**
     * Return the next element from the underlying object
     * @return T
     * */
    T next();

    /**
     * Removes from the underlying object, the last element returned by the iterator
     * @return result of remove
     */
    boolean remove();
}
