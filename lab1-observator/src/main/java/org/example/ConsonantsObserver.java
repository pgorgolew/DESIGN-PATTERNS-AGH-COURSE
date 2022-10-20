package org.example;

public class ConsonantsObserver extends AbstractObserver{
    public ConsonantsObserver(String directoryPath) {
        observerFilename = "consonants-result.txt";
        dirPath = directoryPath;
        initializeObserver();
    }

    @Override
    String createNewSentence(String sentence) {
        return null;
    }
}
