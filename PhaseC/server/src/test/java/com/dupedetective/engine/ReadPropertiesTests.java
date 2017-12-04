package com.dupedetective.engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadPropertiesTests {

    private final String PROPERTIES_FILE = "mongo.properties";

    @Test
    public void readPropertiesTest() {
        ReadProperties mongoProps = new ReadProperties();
        String host = mongoProps.readKey(PROPERTIES_FILE, "host");
        String port = mongoProps.readKey(PROPERTIES_FILE, "port");
        String database = mongoProps.readKey(PROPERTIES_FILE, "db");
        assertEquals("localhost", host);
        assertEquals("27017", port);
        assertEquals("dd", database);
    }
}
