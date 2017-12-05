package com.dupedetective.engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadPropertiesTests {

    @Test
    public void readPropertiesTest() {
        String PROPERTIES_FILE = "mongo-test.properties";
        ReadProperties mongoProps = new ReadProperties();
        String host = mongoProps.readKey(PROPERTIES_FILE, "host");
        String port = mongoProps.readKey(PROPERTIES_FILE, "port");
        String database = mongoProps.readKey(PROPERTIES_FILE, "db");
        assertEquals("localhost", host);
        assertEquals("27017", port);
        assertEquals("dd-test", database);
    }

    @Test(expected = NullPointerException.class)
    public void nullFileTest() {
        String PROPERTIES_FILE = null;
        ReadProperties mongoProps = new ReadProperties();
        String host = mongoProps.readKey(PROPERTIES_FILE, "host");
    }

    @Test(expected = NullPointerException.class)
    public void noFileTest() {
        String PROPERTIES_FILE = "mongo-notexist.properties";
        ReadProperties mongoProps = new ReadProperties();
        String host = mongoProps.readKey(PROPERTIES_FILE, "host");
    }
}
