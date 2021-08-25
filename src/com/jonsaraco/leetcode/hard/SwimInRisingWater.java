package com.jonsaraco.leetcode.hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * Runtime: 32 ms, faster than 12.69% of Java online submissions for Swim in Rising Water.
 * Memory Usage: 39.1 MB, less than 42.66% of Java online submissions for Swim in Rising Water.
 */
public class SwimInRisingWater {

    public static void main(String[] args) {
        //int[][] grid = {{3, 2}, {0, 1}};
//        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int[][] grid = {{10, 12, 4, 6}, {9, 11, 3, 5}, {1, 7, 13, 8}, {2, 0, 15, 14}};
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        return dijkstraAlgorithm(grid)[grid.length - 1][grid.length - 1].weight;
    }

    public static DijkstraNode[][] dijkstraAlgorithm(int[][] grid) {
        DijkstraNode[][] dijkstraNodes = new DijkstraNode[grid.length][grid.length];
        DijkstraNode startNode = new DijkstraNode(grid[0][0]);
        DijkstraNode endNode = addOrGetDijkstraNode(grid.length - 1, grid.length - 1, dijkstraNodes);
        dijkstraNodes[0][0] = startNode;
        PriorityQueue<DijkstraNode> nodeQueue = new PriorityQueue<>();
        nodeQueue.add(startNode);
        while (!nodeQueue.isEmpty()) {
            DijkstraNode current = nodeQueue.poll();
            for (DijkstraNode successor : successorsFromNode(current, dijkstraNodes)) {
                int weight = current.weight + Math.max(0, grid[successor.i][successor.j] - current.weight);
                if (weight < successor.weight) {
                    successor.weight = weight;
                    if (successor == endNode) {
                        return dijkstraNodes;
                    }
                    successor.previous = current;
                    nodeQueue.add(successor);
                }
            }
        }
        return dijkstraNodes;
    }

    private static DijkstraNode addOrGetDijkstraNode(int i, int j, DijkstraNode[][] dijkstraNodes) {
        if (dijkstraNodes[i][j] == null) {
            DijkstraNode dijkstraNode = new DijkstraNode(i, j);
            dijkstraNodes[i][j] = dijkstraNode;
        }
        return dijkstraNodes[i][j];
    }

    private static Set<DijkstraNode> successorsFromNode(DijkstraNode node, DijkstraNode[][] dijkstraNodes) {
        Set<DijkstraNode> successors = new HashSet<>();
        int[] indexMovements = {-1, 0, 1};
        for (int i : indexMovements) {
            for (int j : indexMovements) {
                if (i == 0 || j == 0) {
                    int newI = node.i + i;
                    int newJ = node.j + j;
                    try {
                        successors.add(addOrGetDijkstraNode(newI, newJ, dijkstraNodes));
                    } catch (Exception ignore) {}
                }
            }
        }
        successors.remove(node);
        successors.remove(node.previous);
        return successors;
    }

    static class DijkstraNode implements Comparable<DijkstraNode> {
        int i = 0;
        int j = 0;
        DijkstraNode previous;
        Integer weight;

        public DijkstraNode(int weight) {
            this.weight = weight;
        }

        public DijkstraNode(int i, int j) {
            this.i = i;
            this.j = j;
            this.weight = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(DijkstraNode o) {
            return this.weight.compareTo(o.weight);
        }
    }
}
