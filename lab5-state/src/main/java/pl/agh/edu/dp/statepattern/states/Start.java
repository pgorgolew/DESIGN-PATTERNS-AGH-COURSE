package pl.agh.edu.dp.statepattern.states;

import pl.agh.edu.dp.statepattern.WordChecker;

// Start   ->  aA | bC
public class Start implements State{
    private WordChecker wordChecker;

    @Override
    public void setWordChecker(WordChecker wordChecker) {
        this.wordChecker = wordChecker;
    }

    @Override
    public boolean product(char sign) {
        switch (sign){
            case 'a' -> {
                wordChecker.changeState(new A());
                wordChecker.addProduction("aA");
                return true;
            }
            case 'b' -> {
                wordChecker.changeState(new C());
                wordChecker.addProduction("bC");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean addEpsilonProduction() {
        return false;
    }

    @Override
    public String toString() {
        return "Start";
    }
}
