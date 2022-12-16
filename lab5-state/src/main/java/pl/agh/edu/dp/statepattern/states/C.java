package pl.agh.edu.dp.statepattern.states;

import pl.agh.edu.dp.statepattern.WordChecker;

// C       ->  cB | aC | ε
public class C implements State{
    private WordChecker wordChecker;

    @Override
    public void setWordChecker(WordChecker wordChecker) {
        this.wordChecker = wordChecker;
    }


    @Override
    public boolean product(char sign) {
        switch (sign){
            case 'a' -> {
                wordChecker.changeState(new C());
                wordChecker.addProduction("aC");
                return true;
            }
            case 'c' -> {
                wordChecker.changeState(new B());
                wordChecker.addProduction("cB");
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
        return "C";
    }
}
