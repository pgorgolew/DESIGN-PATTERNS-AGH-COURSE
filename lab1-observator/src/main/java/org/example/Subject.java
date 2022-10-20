package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subject {
    private final String filePath;
    private final List<AbstractObserver> observers = new ArrayList<>();
    public Subject(String filePath) {
        this.filePath = filePath;
    }

    public void addObserver(AbstractObserver observer){
        observers.add(observer);
    }

    public void removeObserver(AbstractObserver observer){
        observers.remove(observer);
    }

    public void parseText(){
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> sentences = Arrays.asList(data.split("\\."));
                sentences.forEach(
                        sentence -> observers.forEach(
                                observer -> observer.parseNewSentence(sentence)
                        )
                );
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
