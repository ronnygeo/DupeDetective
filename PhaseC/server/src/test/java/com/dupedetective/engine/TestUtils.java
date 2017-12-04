package com.dupedetective.engine;

import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class TestUtils {
    /**
     * Read a file to a String
     * @param filename file path of the file
     * @return the String representation of the file
     */
    public String readFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = "";
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
