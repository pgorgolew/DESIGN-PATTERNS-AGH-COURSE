package pl.edu.agh.dp.operation;

import pl.edu.agh.dp.Node;
import pl.edu.agh.dp.visitor.Visitor;

public class MultiplicationOperation extends GenericOperation{
    private final Node A;
    private final Node B;

    public MultiplicationOperation(Node A, Node B) {
        this.A = A;
        this.B = B;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void calculate() {
        resultNode.setNodeMatrix(A.getNodeMatrix().mult(B.getNodeMatrix()));
    }

    @Override
    public void printOperationInfo() {
        System.out.println("--- MULTIPLICATION OPERATION ---");
        System.out.println(System.lineSeparator() + "A:");
        A.getNodeMatrix().print();
        System.out.println(System.lineSeparator() + "B:");
        B.getNodeMatrix().print();
        super.printOperationInfo();
    }
}
