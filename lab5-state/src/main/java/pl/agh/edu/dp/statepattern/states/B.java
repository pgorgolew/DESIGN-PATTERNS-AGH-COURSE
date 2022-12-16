package pl.agh.edu.dp.statepattern.states;

import pl.agh.edu.dp.statepattern.WordChecker;

// B ->  bB | a | ε,
public class B implements State{
    private WordChecker wordChecker;

    @Override
    public void setWordChecker(WordChecker wordChecker) {
        this.wordChecker = wordChecker;
    }


    @Override
    public boolean product(char sign) {
        switch (sign){
            case 'b' -> {
                wordChecker.changeState(new B());
                wordChecker.addProduction("bB");
                return true;
            }
            case 'a' -> {
                wordChecker.changeState(null);
                wordChecker.addProduction("a");
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
        return "B";
    }
}
