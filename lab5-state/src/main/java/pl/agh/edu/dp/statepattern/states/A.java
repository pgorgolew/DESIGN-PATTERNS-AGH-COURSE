package pl.agh.edu.dp.statepattern.states;

import pl.agh.edu.dp.statepattern.WordChecker;

// A  ->  aA | bB | ε,
public class A implements State{
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
                wordChecker.changeState(new B());
                wordChecker.addProduction("bB");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean addEpsilonProduction() {
        wordChecker.addProduction("ε");
        return true;
    }

    @Override
    public String toString() {
        return "A";
    }
}
