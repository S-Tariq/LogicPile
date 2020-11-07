package stariq.datastructures.nodes;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> adjacent = new LinkedList<>();

    GraphNode(int val) {
        this.val = val;
    }
}
