package sc.vsu;

import java.util.Random;

public class GraphAlgorithms {


    public static SimpleGraph generateRandomGraph(){

        Random rnd = new Random();
        SimpleGraph graph = new SimpleGraph();
        graph.vertexNum = (int) (Math.random()*5+5);
        graph.edgeNum = (int) (Math.random()*(graph.vertexNum * (graph.vertexNum - 1) / 2)+5);

        for (int i = 0; i < graph.vertexNum; i++) {
            graph.addVertex(new SimpleGraph.Node(rnd.nextInt()));
            graph.vertexNum--;
        }
        for (int i = 0; i < graph.edgeNum; i++) {
            SimpleGraph.Node node1 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));
            SimpleGraph.Node node2 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));
            while (node1.equals(node2))
                node2 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));

            graph.addEdge(node1,node2);
            graph.edgeNum--;
        }
        return graph;
    }
    public static SimpleDigraph generateRandomDigraph(){

        Random rnd = new Random();
        SimpleDigraph graph = new SimpleDigraph();
        graph.vertexNum = (int) (Math.random()*5+5);
        graph.edgeNum = (int) (Math.random()*(graph.vertexNum * (graph.vertexNum - 1) / 2)+5);

        for (int i = 0; i < graph.vertexNum; i++) {
            graph.addVertex(new SimpleDigraph.Node(rnd.nextInt()));
            graph.vertexNum--;
        }
        for (int i = 0; i < graph.edgeNum; i++) {
            SimpleDigraph.Node node1 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));
            SimpleDigraph.Node node2 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));
            while (node1.equals(node2))
                node2 = graph.nodes.get(rnd.nextInt(graph.nodes.size()));

            graph.addEdge(node1,node2);
            graph.edgeNum--;
        }
        return graph;
    }
}
