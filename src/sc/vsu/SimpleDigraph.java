package sc.vsu;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SimpleDigraph {

    static class Node{
        int a;
        ArrayList<Edge> edgesSource = new ArrayList<Edge>();
        ArrayList<Edge> edgesTarget = new ArrayList<Edge>();


        public Node(int a){
            SimpleGraph.Node newNode = new SimpleGraph.Node();
            newNode.a = a;
        }

    }


    private class Edge{
        Node source;
        Node target;
    }

    private static class Data{
        int a;
        String b;
    }


    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();

    int vertexNum = 0;
    int edgeNum = 0;

    public int vertexCount() {
        return vertexNum;
    }

    public int edgeCount() {
        return edgeNum;
    }

    public void addVertex(Node v){
        nodes.add(v);
        ++vertexNum;
    }

    public void deleteVertex(Node v){
        for (int i = 0; i < nodes.size(); i++) {
            if(v.equals(nodes.get(i))){
                for (int j = 0; j < edges.size(); j++) {
                    if(edges.get(j).source.equals(v) || edges.get(j).target.equals(v)){
                        edges.remove(j);
                    }
                    nodes.remove(v);
                    --vertexNum;
                    return;
                }
            }
        }
        throw new NoSuchElementException("Такого узла нет");
    }

    public void addEdge(Node vertexSource, Node vertexTarget) {
        Edge newEdge = new Edge();
        newEdge.source = vertexSource;
        newEdge.target = vertexTarget;
        vertexSource.edgesSource.add(newEdge);
        vertexTarget.edgesTarget.add(newEdge);
        edges.add(newEdge);
        ++edgeNum;
    }

    public void removeEdge(Node vertexSource, Node vertexTarget) {
        Edge edgeRemove = null;

        for (Edge edge:edges) {
            if(edge.source.equals(vertexSource) && edge.target.equals(vertexTarget)){
                edges.remove(edge);
                edgeRemove = edge;
            }
        }

        assert edgeRemove != null;

        vertexSource.edgesSource.remove(edgeRemove);
        vertexTarget.edgesTarget.remove(edgeRemove);
        --edgeNum;
    }

    public ArrayList<Node> adjacencies(Node v) {
        ArrayList<Node> result = new ArrayList<>();
        for (int j = 0; j < v.edgesTarget.size(); j++) {
            result.add(edges.get(j).target);
        }
        return result;
    }

    private int getNodeIndex(SimpleDigraph.Node v){
        for (int i = 0; i < nodes.size(); i++) {
            if(v.equals(nodes.get(i)))
                return i;
        }
        return -1;
    }
    public String toJSON(){
        String result = "{\"nodes\":[\n";
        for (int i = 0; i < nodes.size(); i++) {
            if(i != nodes.size() - 1)
                result += "{\"id\": \"" + i + "\"},\n";
            else  result += "{\"id\": \"" + i + "\"}\n";
        }
        result += "],\n\"edges\":[\n";
        for (int i = 0; i < edges.size(); i++) {
            if(i != edges.size() - 1)
                result += "{\"source\": \"" + getNodeIndex(edges.get(i).source) +  "\", \"target\": \"" + getNodeIndex(edges.get(i).target) + "\"},\n";
            else result += "{\"source\": \"" + getNodeIndex(edges.get(i).source) +  "\", \"target\": \"" + getNodeIndex(edges.get(i).target) + "\"}\n";
        }
        return result += "]}";
    }

}