package Breadth_first_search;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        boolean[] marked = new boolean[graph.size()];
        int UNIT_COST = 6;
        Arrays.fill(costs, -1);
        Arrays.fill(marked, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        marked[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            marked[x] = true;
            for (int element : graph.get(x)) {
                if (!marked[element]) {
                    if (costs[x] == -1) {
                        costs[element] = UNIT_COST;
                    } else {
                        costs[element] = costs[x] + UNIT_COST;
                    }
                    marked[element] = true;
                    queue.offer(element);
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            /*
            for (int i = 0; i < N; ++i) {
                Collections.sort(graph.get(i));
            }
            for (int i = 1; i <= N; ++i) {
                System.out.println("Node: " + i);
                System.out.println(graph.get(i).toString());
            }
            System.out.println("Start: " + start);
            */
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}