package com.dupedetective.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Read the properties file and create the object
 */
public class ReadProperties {

    /**
     * Default constructor
     */
    public ReadProperties() {
        objClassLoader = getClass().getClassLoader();
    }

    /**
     * Read the key from the file
     * @param propertiesFilename filename
     * @param key key to read
     * @return value of the key
     */
    public String readKey(String propertiesFilename, String key){
        if (propertiesFilename != null && !propertiesFilename.trim().isEmpty()
                && key != null && !key.trim().isEmpty()) {
            try(
                    FileInputStream objFileInputStream = new FileInputStream(objClassLoader.getResource(propertiesFilename).getFile())
            ){
                commonProperties.load(objFileInputStream);
                return String.valueOf(commonProperties.get(key));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    ClassLoader objClassLoader = null;
    Properties commonProperties = new Properties();
}
