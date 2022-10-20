package org.example;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String directoryPath = args[0];
        String fileName = args[1];

        Subject subject = new Subject(Paths.get(directoryPath, fileName));
        subject.addObserver(new WordsObserver(directoryPath));
        subject.addObserver(new VowelsObserver(directoryPath));
        subject.addObserver(new ConsonantsObserver(directoryPath));

        subject.parseText();
    }
}

//E:\code\java\DESIGN-PATTERNS-AGH-COURSE\lab1-observator
//test_file.txt