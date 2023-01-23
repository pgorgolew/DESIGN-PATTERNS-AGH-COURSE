package pl.edu.agh.dp;

import org.ejml.simple.SimpleMatrix;

public class Node {
    private SimpleMatrix nodeMatrix;

    public SimpleMatrix getNodeMatrix() {
        return nodeMatrix;
    }

    public void setNodeMatrix(SimpleMatrix nodeMatrix) {
        this.nodeMatrix = nodeMatrix;
    }
}
