package com.dupedetective.engine.winnow.tests;

import com.dupedetective.engine.TestUtils;
import com.dupedetective.engine.winnow.Winnow;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class TestWinnow {

  /*
    Logger for error or info messages
  */
  final static Logger logger = Logger.getLogger(TestWinnow.class);
  TestUtils t;

  @Before
  public void setup() throws URISyntaxException {
    t = new TestUtils();
  }

  @Test
  public void testWinnow() {
    assertEquals(0.18, getSimilarity(t.readFile("one.java"), t.readFile("two.java")), 0.01);
  }

  @Test
  public void testWinnowClones() {
    assertEquals(0.54, getSimilarity(t.readFile("Clone1.java"), t.readFile("Clone2.java")), 0.01);
  }

  private float getSimilarity(String data1, String data2) {
    Winnow nGram = new Winnow(data1, data2);
    nGram.calcSimilarityRate();
    return nGram.getSimilarity();
  }
}
