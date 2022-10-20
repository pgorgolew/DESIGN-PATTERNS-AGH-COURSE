package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

abstract class AbstractObserver {
    Path path;
    FileWriter fileWriter;
    String observerFilename;
    String dirPath;

    private void createObserverFile(){
        try {
            Files.deleteIfExists(Paths.get(dirPath, observerFilename));
            path = Files.createFile(Paths.get(dirPath, observerFilename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileWriter(){
        try {
            fileWriter = new FileWriter(path.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void initializeObserver(String directoryPath){
        dirPath = directoryPath;
        createObserverFile();
        createFileWriter();
    }

    void writeToFile(String sentence){
        try {
            fileWriter.write(sentence + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void closeFileWriter(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void parseNewSentence(String sentence) {
        writeToFile(createNewSentence(sentence.replaceAll("\\p{Punct}", "").trim()));
    }
    abstract String createNewSentence(String sentence);
}
