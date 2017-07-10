package com.oracle.oep.sparkcql.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CqlEventsComparatorTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testRemoveTimestamp() {
    assertEquals("1,PROCESSING,9000,A,B,1,1,1,1",
        CqlEventsComparator.removeTimestamp(
            "1,3140003040200020339,PROCESSING,9000,A,B,1,1,1,1", 2));
  }
  
  @Test
  public void testCompareWithoutTimeStamp() {
    assertTrue(CqlEventsComparator.compareWithoutTimestamp(
        Arrays.asList("1,PROCESSING,9000,A,B,1,1,1,1"),
        Arrays.asList("1,3140003040200020339,PROCESSING,9000,A,B,1,1,1,1"), 2));
    boolean expEqualActual = CqlEventsComparator
        .compareWithoutTimestamp(
            Arrays
                .asList("PLUS,1,2,2,4,0.4,4.2,1.4672272205352783,2.6677699089050293,"
                    + "1.0,0.7648421949641616,0.7753974799181138,0.7953988468767829,0.6107259563885852,1.2551689965879207,"
                    + "2.0137526834646735,1.0137526834646737,0.8879039967022957"),
            Arrays
                .asList("PLUS,1454584572133000001,1,2,2,4,0.4,4.2,1.4672272205352783,2.6677699089050293,"
                    + "1.0,0.7648421949641616,0.7753974799181138,0.7953988468767829,0.6107259563885852,1.2551689965879207,"
                    + "2.0137526834646735,1.0137526834646737,0.8879039967022957"),
            2);
    assertTrue(expEqualActual);
  }
  
  @Test
  public void testCompareUnordered() {
    assertTrue(CqlEventsComparator.compareUnordered(
        Arrays.asList("1,PROCESSING,9000,A,B,1,1,1,1"),
        Arrays.asList("1,PROCESSING,9000,A,B,1,1,1,1")));
    boolean expEqualActual = CqlEventsComparator
        .compareUnordered(
            Arrays
                .asList("PLUS,1,2,2,4,0.4,4.2,1.4672272205352783,2.6677699089050293,"
                    + "1.0,0.7648421949641616,0.7753974799181138,0.7953988468767829,0.6107259563885852,1.2551689965879207,"
                    + "2.0137526834646735,1.0137526834646737,0.8879039967022957"),
            Arrays
                .asList("PLUS,1,2,2,4,0.4,4.2,1.4672272205352783,2.6677699089050293,"
                    + "1.0,0.7648421949641616,0.7753974799181138,0.7953988468767829,0.6107259563885852,1.2551689965879207,"
                    + "2.0137526834646735,1.0137526834646737,0.8879039967022957")
          );
    assertTrue(expEqualActual);
  }
}
