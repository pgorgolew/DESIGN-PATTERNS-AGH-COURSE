package pl.edu.agh.dp.visitor;

import pl.edu.agh.dp.operation.*;

public interface Visitor {
    void visit(AddOperation addOperation) throws Exception;
    void visit(InverseOperation inverseOperation);
    void visit(MultiplicationOperation  multiplicationOperation);
    void visit(ScalarMultiplicationOperation scalarMultiplicationOperation);
    void visit(SubtractOperation subtractOperation) throws Exception;
}
