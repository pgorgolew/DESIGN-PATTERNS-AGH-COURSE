package pl.edu.agh.dp.operation;

import pl.edu.agh.dp.Node;

public abstract class GenericOperation implements Operation {
    protected Node resultNode = new Node();

    public Node getResult(){
        return resultNode;
    };

    public void printOperationInfo(){
        System.out.println(System.lineSeparator() + "result:");
        resultNode.getNodeMatrix().print();
        System.out.println(System.lineSeparator());
    }
}
