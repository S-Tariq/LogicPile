package stariq.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPaths {
    public static void main(String[] args) {
        int[][] array = new int[][] {{1,2},{3},{3},{}};
        array = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
      //  array = new int[][] {{3,1},{3,2},{3},{}};
        for(List<Integer> i : allPathsSourceTargetDFS(array)) {
            System.out.println(i);
        }
    }

    static class GraphNode {
        int val;
        List<Integer> path;

        GraphNode(int val) {
            this.val = val;
            this.path = new ArrayList<>();
        }
    }

    // BFS
    public static List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<GraphNode> queue = new LinkedList<>();

        GraphNode initNode = new GraphNode(0);
        initNode.path.add(0);
        queue.add(initNode);

        while(!queue.isEmpty()) {
            GraphNode current = queue.poll();
            if(current.val == graph.length - 1) {
                result.add(current.path);
                continue;
            }
            for(int i : graph[current.val]) {
                GraphNode newNode = new GraphNode(i);
                if(graph[current.val].length > 1) {
                    newNode.path = new LinkedList<>(current.path);
                } else {
                    newNode.path = current.path;
                }
                newNode.path.add(i);
                queue.add(newNode);
            }
        }
        return result;
    }

    // DFS
    public static List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfsSearch(graph, 0, result, path);
        return result;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if(node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i : graph[node]) {
            path.add(i);
            dfsSearch(graph, i, result, path);
            path.remove(path.size() - 1);
        }
    }
}
