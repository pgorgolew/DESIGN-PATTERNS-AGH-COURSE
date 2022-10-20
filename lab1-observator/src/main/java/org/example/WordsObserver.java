package org.example;

public class WordsObserver extends AbstractObserver {
    public WordsObserver(String directoryPath) {
        observerFilename = "words-result.txt";
        initializeObserver(directoryPath);
    }

    @Override
    String createNewSentence(String sentence) {
        return sentence + " | " + sentence.split(" ").length;
    }
}
