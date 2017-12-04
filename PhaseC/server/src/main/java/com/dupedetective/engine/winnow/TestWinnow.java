package com.dupedetective.engine.winnow;

import org.apache.log4j.Logger;

import java.io.File;

public class TestWinnow {
    /*
      Logger for error or info messages
    */
    final static Logger logger = Logger.getLogger(TestWinnow.class);

    public static void main(String[] args) {
        File one = new File("/Study/CS5500/Project/team-27/PhaseC/src/main/java/cs5500/project/com.dupedetective.engine/winnow/input/one.java");
        File two = new File("/Study/CS5500/Project/team-27/PhaseC/src/main/java/cs5500/project/com.dupedetective.engine/winnow/input/two.java");

        if (one.isFile() && two.isFile()) {

            Winnow nGram = new Winnow(one.getAbsolutePath(), two.getAbsolutePath());

            float similarity = nGram.getSimilarity();
        } else {
            logger.error("File not found");
        }

    }
}
