package pl.edu.agh.dp.operation;

import pl.edu.agh.dp.Node;
import pl.edu.agh.dp.visitor.Visitor;

public class InverseOperation extends GenericOperation{
    private final Node A;

    public InverseOperation(Node A) {
        this.A = A;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void calculate() {
        resultNode.setNodeMatrix(A.getNodeMatrix().invert());
    }

    @Override
    public void printOperationInfo() {
        System.out.println("--- INVERSE OPERATION ---");
        System.out.println(System.lineSeparator() + "A:");
        A.getNodeMatrix().print();
        super.printOperationInfo();
    }
}

