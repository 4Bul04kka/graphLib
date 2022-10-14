package sc.vsu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SimpleDigraph graph = GraphAlgorithms.generateRandomDigraph();
        System.out.println(graph.toJSON());
    }
}