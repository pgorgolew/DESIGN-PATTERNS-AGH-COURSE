package org.example;

import java.util.Arrays;
import java.util.List;

public class VowelsObserver extends AbstractObserver{
    List<Character> vowels = Arrays.asList('a', 'o', 'e', 'i', 'u');

    public VowelsObserver(String directoryPath) {
        observerFilename = "vowels-result.txt";
        initializeObserver(directoryPath);
    }

    @Override
    String createNewSentence(String sentence) {
        long vowelsCount = sentence.toLowerCase()
                                   .chars()
                                   .mapToObj(c -> (char) c)
                                   .filter(c -> vowels.contains(c))
                                   .count();

        return sentence + " | " + vowelsCount;
    }
}
