package stariq.algorithms.graph;

import stariq.datastructures.nodes.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public boolean hasPath(GraphNode source, GraphNode destination) {
        Queue<GraphNode> nextToVisit = new LinkedList<>();
        HashSet<GraphNode> visited = new HashSet<>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()) {
            GraphNode node = nextToVisit.poll();
            if(node == destination) {
                return true;
            }
            if(visited.contains(node)) {
                continue;
            }
            visited.add(node);
            for(GraphNode child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
