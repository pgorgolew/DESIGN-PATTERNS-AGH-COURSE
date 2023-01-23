package pl.edu.agh.dp;

import pl.edu.agh.dp.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Operation> vertices = new ArrayList<>();

    public Node add(Operation operation){
        vertices.add(operation);
        return operation.getResult();
    }
}
