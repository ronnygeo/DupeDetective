package com.dupedetective.engine.winnow.tests;

import com.dupedetective.engine.winnow.Winnow;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestWinnow {
    /*
      Logger for error or info messages
    */
    final static Logger logger = Logger.getLogger(TestWinnow.class);

    @Test
    public void testWinnow() {
        assertEquals(0.18, getSimilarity("one.java", "two.java"), 0.01);
    }

    @Test
    public void testWinnowClones() {
        assertEquals(0.69, getSimilarity("Clone1.java", "Clone2.java"), 0.01);
    }

    private float getSimilarity(String file1, String file2) {
        ClassLoader classLoader = getClass().getClassLoader();
        File one = new File(classLoader.getResource(file1).getPath());
        File two = new File(classLoader.getResource(file2).getPath());

        if (one.isFile() && two.isFile()) {

            Winnow nGram = new Winnow(one.getAbsolutePath(), two.getAbsolutePath());

            return nGram.getSimilarity();

        } else {
            logger.error("File not found");
            return 0;
        }
    }
}
