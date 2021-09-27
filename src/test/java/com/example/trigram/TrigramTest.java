package com.example.trigram;

import com.example.exception.TrigramException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.example.utils.TestUtil.ERROR_MESSAGE_THREE_WORDS_CHECK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TrigramTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void threeWordsNotSuppliedThenFail(){
        expectedException.expect(TrigramException.class);
        expectedException.expectMessage(ERROR_MESSAGE_THREE_WORDS_CHECK);
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift"});
    }

    @Test
    public void moreThanThreeWordsSuppliedThenFail(){
        expectedException.expect(TrigramException.class);
        expectedException.expectMessage(ERROR_MESSAGE_THREE_WORDS_CHECK);
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift", "and", "his", "Airship"});
    }

    @Test
    public void generateKeySuccess() {
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift", "and",});
        assertEquals("tom swift", trigram.getNextKey());
    }
    @Test
    public void specialCharactersSuppliedThenSuccess(){
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift", "******"});
    }

    @Test
    public void generateKeyValidationsSuccess() {
        Trigram trigram = new Trigram(new String[] {"Tom,,,,,%&())*&", ">>>swift!!!!", "and"});
        assertEquals("tom swift", trigram.getNextKey());
    }

    @Test
    public void generateNextKeySuccess() {
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift", "and",});
        String next = trigram.getNextValue();
        assertEquals("swift and", trigram.concatWords(next));
    }

    @Test
    public void nextValuesForRandomTrigram() {
        Trigram trigram = new Trigram(new String[] {"Tom", "Swift", "and"});
        assertEquals("and", trigram.getNextValue());
    }

}
