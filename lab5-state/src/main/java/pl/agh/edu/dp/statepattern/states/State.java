package pl.agh.edu.dp.statepattern.states;

import pl.agh.edu.dp.statepattern.WordChecker;

public interface State {
    void setWordChecker(WordChecker wordChecker);
    boolean product(char sign);
    boolean addEpsilonProduction();
}
