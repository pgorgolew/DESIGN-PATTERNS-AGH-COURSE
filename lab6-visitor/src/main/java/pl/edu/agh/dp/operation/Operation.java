package pl.edu.agh.dp.operation;

import pl.edu.agh.dp.Node;
import pl.edu.agh.dp.visitor.Visitor;

public interface Operation {
    void accept(Visitor visitor) throws Exception;
    void calculate() throws Exception;
    Node getResult();
}
