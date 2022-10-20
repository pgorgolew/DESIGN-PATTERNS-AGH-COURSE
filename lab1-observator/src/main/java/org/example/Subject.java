package org.example;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Subject {
    private final Path path;
    private final List<AbstractObserver> observers = new ArrayList<>();

    public Subject(Path filePath) {
        path = filePath;
    }

    public void addObserver(AbstractObserver observer){
        observers.add(observer);
    }

    public void removeObserver(AbstractObserver observer){
        observers.remove(observer);
    }

    public void parseText(){
        try {
            Scanner reader = new Scanner(path.toFile());
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                List<String> sentences = Arrays.asList(data.split("\\."));

                sentences.stream()
                        .filter(s -> Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE).matcher(s).find())
                        .forEach(
                                sentence -> observers.forEach(
                                    observer -> observer.parseNewSentence(sentence)
                                )
                        );
            }

            reader.close();
            observers.forEach(AbstractObserver::closeFileWriter);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
