package cs5500.project.phaseb;

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
    public T parse(String txt);

    /**
     * Sets the version of the Parser to use
     */
    public void setVersion();
}
