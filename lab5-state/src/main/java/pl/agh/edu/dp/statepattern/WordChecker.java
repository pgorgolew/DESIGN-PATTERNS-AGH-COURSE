package pl.agh.edu.dp.statepattern;

import pl.agh.edu.dp.statepattern.states.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordChecker {
    private State state;
    public int wordLength;
    private final List<Character> word;
    private final List<State> stateSequence;
    private final List<String> productionSequence;

    public WordChecker(String word, State initState) {
        this.word = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        this.wordLength = word.length();
        this.stateSequence = new ArrayList<>(this.wordLength);
        this.state = initState;
        this.state.setWordChecker(this);
        this.stateSequence.add(this.state);
        this.productionSequence = new ArrayList<>(this.wordLength);
    }

    public boolean check(){
        char currentCharacter;
        for (int i = 0; i < wordLength; i++) {
            currentCharacter = word.get(i);
            if (!state.product(currentCharacter))
                return false;

            stateSequence.add(state);
        }

        return state == null || state.addEpsilonProduction();
    }

    public void changeState(State state){
        this.state = state;
        if (state != null)
            state.setWordChecker(this);
    }

    public void addProduction(String production){
        productionSequence.add(production);
    }
    public List<State> getStateSequence() {
        return stateSequence;
    }

    public List<String> getProductionSequence() {
        return productionSequence;
    }
}
