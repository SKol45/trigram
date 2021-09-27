package com.example.trigram;

import com.example.exception.FileOperationException;
import com.example.exception.TrigramException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static com.example.utils.Util.*;

public class TrigramGenerator {

    private final Map<String, Trigram> trigramMap;
    private final Random random;

    public TrigramGenerator(String fileInputName, String outputFileName) throws FileOperationException {
        String input = null;

        try {
            input = Files.readString(Path.of(fileInputName));
            this.trigramMap = generateTrigrams(input);
            this.random = new Random();
            String resultTrigram = writeTrigrams();
            Files.writeString(Path.of(outputFileName), resultTrigram, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ioException) {
            throw new FileOperationException(ERROR_MESSAGE_WHILE_FETCHING_FILE);
        }
    }

    private Map<String, Trigram> generateTrigrams(String input) {
        Map<String, Trigram> trigramMap = new HashMap<String, Trigram>();

        String[] words = input.split(REGEX_WHITE_SPACE);
        if (words.length <= 3) {
            throw new TrigramException(ERROR_MESSAGE_ATLEAST_3_WORDS);
        }
        int lastnthWord = words.length - 3;
        for (int i = 0; i <= lastnthWord; i++) {
            String[] inputArray = new String[3];
            inputArray[0] = words[i];
            inputArray[1] = words[i + 1];
            inputArray[2] = words[i + 2];
            Trigram trigram = new Trigram(inputArray);
            String key = trigram.getNextKey();
            if (trigramMap.containsKey(key)) {
                trigramMap.get(key).addNextValue(trigram.getNextValue());
            } else {
                trigramMap.put(key, trigram);
            }
        }

        return trigramMap;
    }

    public String writeTrigrams() {
        StringBuilder s = new StringBuilder();

        String key = getStartKey();
        while (this.trigramMap.containsKey(key)) {
            Trigram trigram = this.trigramMap.get(key);
            String word = trigram.getNextValue();
            s.append(word).append(REGEX_WHITE_SPACE);
            key = trigram.concatWords(word);
        }

        return s.toString();
    }

    private String getStartKey() {
        Set<String> keys = this.trigramMap.keySet();
        int randomIndex = this.random.nextInt(keys.size());
        int i = 0;
        for (String key : keys) {
            if (i == randomIndex) {
                return key;
            }
            i++;
        }

        return null;
    }

    public Map<String, Trigram> getTrigrams() {
        return this.trigramMap;
    }
}
