package edu.luc.cs271.wordcount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// I added the below
import java.util.HashMap;
import java.util.Arrays;

public class TestWordCounter {

    // TODO complete this test class

    // TODO declare a reference to the SUT (system under test), i.e., WordCounter
    WordCounter words;


    @Before
    public void setUp() {
        // TODO create the SUT instance
        words = new WordCounter( new HashMap<>());

    }

    @After
    public void tearDown() {
        // TODO set the SUT instance to null
        words = null;
    }

    @Test
    public void testGetCountEmpty() {
        // TODO verify that the SUT initially returns an empty map
        assertTrue(words.getCounts().isEmpty());
        //fail();

    }

    @Test
    public void testGetCountNonEmpty() {
        // TODO run the SUT on a specific String iterator with some repeated words,
        // then use assertions to verify the correct counts
        // do this for at least two words in the iterator and two not in the iterator
        words.countWords( Arrays.asList("dog","dog", "cat", "cow", "mouse").iterator());

        assertEquals(words.getCount("dog"), 2);
        assertEquals(words.getCount("cat"), 1);
        assertEquals(words.getCount("fake"), 0);
        assertEquals(words.getCount("man"), 0);


       //fail();

    }
}