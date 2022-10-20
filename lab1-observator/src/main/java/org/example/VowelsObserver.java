package org.example;

public class VowelsObserver extends AbstractObserver{
    public VowelsObserver(String directoryPath) {
        observerFilename = "vowels-result.txt";
        dirPath = directoryPath;
        initializeObserver();
    }

    @Override
    String createNewSentence(String sentence) {
        return null;
    }
}
