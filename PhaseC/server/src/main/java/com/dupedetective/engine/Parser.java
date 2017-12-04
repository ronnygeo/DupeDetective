package com.dupedetective.engine;

/**
 * A generic Parser interface that can parse string into the given type
 * @param <T> parses data to this type
 */
public interface Parser<T> {

    /**
     * Parse the given String into type T
     * @param txt the file content as a String to be parsed
     * @return the parsed object T
     */
    T parse(String txt);

}
