package org.example;

public class Main {
    public static void main(String[] args) {
        String directoryPath = args[0];
        String fileName = args[1];

        Subject subject = new Subject(directoryPath + fileName);
        subject.addObserver(new WordsObserver(directoryPath));
        subject.addObserver(new VowelsObserver(directoryPath));
        subject.addObserver(new ConsonantsObserver(directoryPath));

        subject.parseText();
    }
}