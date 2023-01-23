package pl.edu.agh.dp;

import org.ejml.simple.SimpleMatrix;
import pl.edu.agh.dp.operation.*;
import pl.edu.agh.dp.visitor.VisitorImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double scalar1 = 2.137;
        double scalar2 = 0.678;

        Random random = new Random();
        SimpleMatrix A = SimpleMatrix.random_DDRM(3,3,-10,10, random);
        SimpleMatrix B = SimpleMatrix.random_DDRM(3,5,-10,10, random);
        SimpleMatrix C = SimpleMatrix.random_DDRM(5,3,-10,10, random);
        SimpleMatrix D = SimpleMatrix.random_DDRM(3,3,-10,10, random);

        Node nodeA = new Node();
        nodeA.setNodeMatrix(A);
        Node nodeB = new Node();
        nodeB.setNodeMatrix(B);
        Node nodeC = new Node();
        nodeC.setNodeMatrix(C);
        Node nodeD = new Node();
        nodeD.setNodeMatrix(D);

        Graph graph = new Graph();
        Node inverseNode = graph.add(new InverseOperation(nodeD));
        Node addNode = graph.add(new AddOperation(inverseNode, nodeA));
        Node scalarNode2 = graph.add(new ScalarMultiplicationOperation(addNode, scalar2));

        Node scalarNode1 = graph.add(new ScalarMultiplicationOperation(nodeC, scalar1));
        Node multiplicationNode = graph.add(new MultiplicationOperation(nodeB, scalarNode1));

        Node subtractNode = graph.add(new SubtractOperation(multiplicationNode, scalarNode2));

        VisitorImpl visitor = new VisitorImpl();
        graph.vertices.forEach(v -> {
            try {
                v.accept(visitor);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("--- FINAL MATRIX ---");
        subtractNode.getNodeMatrix().print();
    }
}
