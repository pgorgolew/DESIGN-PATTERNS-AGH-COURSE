package pl.agh.edu.dp.statepattern;

import pl.agh.edu.dp.statepattern.states.Start;

public class AppMain {
    public static void main(String[] args) {
        WordChecker checker;
        for (String word : args) {
            checker = new WordChecker(word, new Start());
            boolean result = checker.check();

            System.out.println("=========================");
            System.out.println("Checking word '" + word + "'");
            System.out.println("Result:\t\t\t\t" + result);
            System.out.println("States list:\t\t" + checker.getStateSequence());
            System.out.println("Productions list:\t" + checker.getProductionSequence());
        }
    }
}
