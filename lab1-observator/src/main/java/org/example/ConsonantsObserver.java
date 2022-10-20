package org.example;

import java.util.Arrays;
import java.util.List;

public class ConsonantsObserver extends AbstractObserver{
    List<Character> notConsonants = Arrays.asList('a', 'o', 'e', 'i', 'u', ' ');

    public ConsonantsObserver(String directoryPath) {
        observerFilename = "consonants-result.txt";
        initializeObserver(directoryPath);
    }

    @Override
    String createNewSentence(String sentence) {
        long consonantsCount = sentence.toLowerCase()
                                       .chars()
                                       .mapToObj(c -> (char) c)
                                       .filter(c -> !notConsonants.contains(c))
                                       .count();

        return sentence + " | " + consonantsCount;
    }
}
