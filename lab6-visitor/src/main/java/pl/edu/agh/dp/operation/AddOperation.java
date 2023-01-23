package pl.edu.agh.dp.operation;

import org.ejml.simple.SimpleMatrix;
import pl.edu.agh.dp.Node;
import pl.edu.agh.dp.visitor.Visitor;

public class AddOperation extends GenericOperation{
    private final Node A;
    private final Node B;

    public AddOperation(Node A, Node B) {
        this.A = A;
        this.B = B;
    }


    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visit(this);
    }

    @Override
    public void calculate() throws Exception {
        SimpleMatrix AMatrix = A.getNodeMatrix();
        SimpleMatrix BMatrix = B.getNodeMatrix();
        if (AMatrix.numCols() != BMatrix.numCols() || AMatrix.numRows() != BMatrix.numRows()){
            throw new Exception("Matrixes don't have the same dimensions");
        }


        resultNode.setNodeMatrix(AMatrix.plus(BMatrix));
    }

    @Override
    public void printOperationInfo() {
        System.out.println("--- ADD OPERATION ---");
        System.out.println(System.lineSeparator() + "A:");
        A.getNodeMatrix().print();
        System.out.println(System.lineSeparator() + "B:");
        B.getNodeMatrix().print();
        super.printOperationInfo();
    }
}
