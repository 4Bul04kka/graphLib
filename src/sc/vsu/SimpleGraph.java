package sc.vsu;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class SimpleGraph {


    static class Node{
        int a;
        ArrayList<Edge> edges = new ArrayList<Edge>();

        public Node(int a){
            Node newNode = new Node();
            newNode.a = a;
        }

        public Node() {

        }
    }
    private class Edge{
        Node source;
        Node target;
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

    public void addEdge(Node vertexFirst, Node vertexSecond) {
        Edge newEdge = new Edge();
        newEdge.source = vertexFirst;
        newEdge.target = vertexSecond;
        vertexFirst.edges.add(newEdge);
        vertexSecond.edges.add(newEdge);
        edges.add(newEdge);
        ++edgeNum;
    }

    public void removeEdge(Node vertexFirst, Node vertexSecond) {
        Edge edgeRemove = null;

        for (Edge edge:edges) {
            if(edge.source.equals(vertexFirst) && edge.target.equals(vertexSecond)){
                edges.remove(edge);
                edgeRemove = edge;
            }
        }

        assert edgeRemove != null;

        vertexFirst.edges.remove(edgeRemove);
        vertexSecond.edges.remove(edgeRemove);
        --edgeNum;
    }

    public ArrayList<Node> adjacencies(Node v) {
        ArrayList<Node> result = new ArrayList<>();
        for (int j = 0; j < v.edges.size(); j++) {
            result.add(edges.get(j).target);
        }
        return result;
    }


    private int getNodeIndex(Node v){
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
