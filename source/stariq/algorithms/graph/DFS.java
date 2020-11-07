package stariq.algorithms.graph;

import stariq.datastructures.nodes.GraphNode;

import java.util.HashMap;
import java.util.HashSet;

public class DFS {

    HashMap<Integer, GraphNode> nodeLookup = new HashMap<>();

    public GraphNode getNode(int val) {
        return nodeLookup.get(val);
    }

    public boolean hasPath(int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        HashSet<GraphNode> visited = new HashSet<>();
        return hasPath(s, d, visited);
    }

    public boolean hasPath(GraphNode source, GraphNode destination, HashSet<GraphNode> visited) {
        if(visited.contains(source)) {
            return false;
        }
        visited.add(source);
        if(source == destination) {
            return true;
        }
        for(GraphNode child : source.adjacent) {
            if(hasPath(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
