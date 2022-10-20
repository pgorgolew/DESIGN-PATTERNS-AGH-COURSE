package org.example;

public class WordsObserver extends AbstractObserver {
    public WordsObserver(String directoryPath) {
        observerFilename = "words-result.txt";
        dirPath = directoryPath;
        initializeObserver();
    }

    @Override
    String createNewSentence(String sentence) {
        return null;
    }
}
