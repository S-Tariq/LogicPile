package stariq.algorithms.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/
// Implemented DFS and BFS versions of finding number of islands.
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        if(m == 0) return 0;

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    findAdjacentLand_BFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findAdjacentLand_DFS(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] == '0')
        {
            return;
        }

        grid[i][j] = '0';
        findAdjacentLand_DFS(grid, i, j+1);
        findAdjacentLand_DFS(grid, i, j-1);
        findAdjacentLand_DFS(grid, i+1, j);
        findAdjacentLand_DFS(grid, i-1, j);
    }

    static class Point {
        int i; int j;
        Point(int i, int j) {this.i = i; this.j = j;}
    }

    public static void findAdjacentLand_BFS(char[][] grid, int init_i, int init_j) {
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(init_i, init_j));
        while(!points.isEmpty()) {
            Point point = points.poll();
            int i = point.i; int j = point.j;
            char val = grid[i][j];
            if(val == '1') {
                grid[i][j] = '0';
                addToQueue(points, grid, i-1, j);
                addToQueue(points, grid, i+1, j);
                addToQueue(points, grid, i, j-1);
                addToQueue(points, grid, i, j+1);
            }
        }
    }

    public static void addToQueue(Queue<Point> points, char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            char c = grid[i][j];
            if(c == '1') {
                points.add(new Point(i, j));
            }
        }
    }

    // Lengthy - improved above by adding a method which takes care of repeated code.
    public void findAdjacentLand_BFS2(char[][] grid, int init_i, int init_j) {
        class Point {
            int i; int j;
            Point(int i, int j) {this.i = i; this.j = j;}
        }

        Queue<Point> points = new LinkedList<>();
        points.add(new Point(init_i, init_j));
        while(!points.isEmpty()) {
            Point point = points.poll();
            int i = point.i; int j = point.j;
            char val = grid[i][j];
            if(val == '1') {
                grid[i][j] = '0';
                if(i-1 >= 0) {
                    char topVal = grid[i-1][j];
                    if(topVal == '1')
                        points.add(new Point(i-1, j));
                }
                if(i+1 < grid.length) {
                    char bottomVal = grid[i+1][j];
                    if(bottomVal == '1')
                        points.add(new Point(i+1, j));
                }
                if(j-1 >= 0) {
                    char leftVal = grid[i][j-1];
                    if(leftVal == '1')
                        points.add(new Point(i, j-1));
                }
                if(j+1 < grid[0].length) {
                    char rightVal = grid[i][j+1];
                    if(rightVal == '1')
                        points.add(new Point(i, j+1));
                }
            }
        }
    }
}
