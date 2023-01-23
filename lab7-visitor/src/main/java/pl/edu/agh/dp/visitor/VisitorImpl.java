package pl.edu.agh.dp.visitor;

import org.ejml.simple.SimpleMatrix;
import pl.edu.agh.dp.operation.*;

public class VisitorImpl implements Visitor{
    @Override
    public void visit(AddOperation addOperation) throws Exception {
        addOperation.calculate();
        addOperation.printOperationInfo();
    }

    @Override
    public void visit(InverseOperation inverseOperation) {
        inverseOperation.calculate();
        inverseOperation.printOperationInfo();
    }

    @Override
    public void visit(MultiplicationOperation multiplicationOperation) {
        multiplicationOperation.calculate();
        multiplicationOperation.printOperationInfo();
    }

    @Override
    public void visit(ScalarMultiplicationOperation scalarMultiplicationOperation) {
        scalarMultiplicationOperation.calculate();
        scalarMultiplicationOperation.printOperationInfo();
    }

    @Override
    public void visit(SubtractOperation subtractOperation) throws Exception {
        subtractOperation.calculate();
        subtractOperation.printOperationInfo();
    }
}
