package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OppositeObserver extends AbstractObserver{
    public OppositeObserver(String directoryPath) {
        observerFilename = "opposite-result.txt";
        initializeObserver(directoryPath);
    }

    @Override
    String createNewSentence(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
