package stariq.datastructures.graph;

import stariq.datastructures.nodes.GraphNode;

import java.util.HashSet;

public class DFS {

    public boolean hasPath(GraphNode source, GraphNode destination) {
        HashSet<GraphNode> visited = new HashSet<>();
        return hasPath(source, destination, visited);
    }

    public boolean hasPath(GraphNode source, GraphNode destination, HashSet<GraphNode> visited) {
        if(source == destination) {
            return true;
        }
        if(visited.contains(source)) {
            return false;
        }
        visited.add(source);
        for(GraphNode child : source.adjacent) {
            if(hasPath(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
