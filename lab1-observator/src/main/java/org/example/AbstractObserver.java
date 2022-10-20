package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

abstract class AbstractObserver {
    Path path;
    FileWriter fileWriter;
    String observerFilePath;
    String observerFilename;
    String dirPath;
    private void createObserverFile(){
        try {
            path = Files.createFile(Paths.get(dirPath, observerFilename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileWriter(){
        try {
            fileWriter = new FileWriter(observerFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void initializeObserver(){
        createObserverFile();
        createFileWriter();
    }

    void writeToFile(String sentence){
        String line = sentence + System.lineSeparator();
        try {
            fileWriter.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void parseNewSentence(String sentence) {
        writeToFile(createNewSentence(sentence));
    }
    abstract String createNewSentence(String sentence);
}
