package sc.vsu;

public class Main {
    public static void main(String[] args) {
        SimpleGraph graph = GraphAlgorithms.generateRandomGraph();
        System.out.println(graph.toJSON());
    }
}