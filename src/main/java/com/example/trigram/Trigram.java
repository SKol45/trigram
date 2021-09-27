package com.example.trigram;

import com.example.exception.TrigramException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.utils.Util.*;

public class Trigram {
    private List<String> nextValue;
    private String nextKey;
    private Random random;

    public Trigram(String[] trigram) {
        if (trigram.length != 3) {
            throw new TrigramException(ERROR_MESSAGE_MUST_SUPPLY_THREE_WORDS);
        }
        this.random = new Random();
        this.nextKey = this.generateKey(trigram);
        this.nextValue = new ArrayList<String>();
        this.nextValue.add(trigram[2]);
    }

    private String generateKey(String[] words) {
        return words[0].toLowerCase().replaceAll(NO_ALPHANUM, NO_ALPHANUM_REPLACEMENT) + REGEX_WHITE_SPACE + words[1].toLowerCase().replaceAll(NO_ALPHANUM, NO_ALPHANUM_REPLACEMENT);
    }

    public String getNextKey() {
        return this.nextKey;
    }

    public String getNextValue() {
        int randomIndex = this.random.nextInt(this.nextValue.size());

        return this.nextValue.get(randomIndex);
    }

    public void addNextValue(String nextWord) {
        this.nextValue.add(nextWord);
    }

    public String concatWords(String next) {
        String firstWord = null;
        String[] keyArray = this.nextKey.split(REGEX_WHITE_SPACE);
        if (keyArray.length == 2) {
            firstWord = this.nextKey.split(REGEX_WHITE_SPACE)[1];
        } else {
            firstWord = " ";
        }
        String secondWord = next.toLowerCase().replaceAll(NO_ALPHANUM, NO_ALPHANUM_REPLACEMENT);

        return firstWord + REGEX_WHITE_SPACE + secondWord;
    }

    public List<String> values() {
        return nextValue;
    }

}
