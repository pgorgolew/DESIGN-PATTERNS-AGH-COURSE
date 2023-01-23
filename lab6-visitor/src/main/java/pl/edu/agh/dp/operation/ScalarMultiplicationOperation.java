package pl.edu.agh.dp.operation;

import pl.edu.agh.dp.Node;
import pl.edu.agh.dp.visitor.Visitor;

public class ScalarMultiplicationOperation extends GenericOperation{
    private final Node A;
    private final double scalar;
    public ScalarMultiplicationOperation(Node A, double scalar) {
        this.A = A;
        this.scalar = scalar;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void calculate() {
        resultNode.setNodeMatrix(A.getNodeMatrix().scale(scalar));
    }

    @Override
    public void printOperationInfo() {
        System.out.println("--- SCALAR MULTIPLICATION OPERATION ---");
        System.out.println(System.lineSeparator() + "A:");
        A.getNodeMatrix().print();
        System.out.println(System.lineSeparator() + "scalar:");
        System.out.println(scalar);
        super.printOperationInfo();
    }
}
