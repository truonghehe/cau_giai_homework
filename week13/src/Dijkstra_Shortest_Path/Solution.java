package Dijkstra_Shortest_Path;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */
    static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }

    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Cost>> myEdges = new ArrayList<>(n + 1);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            res.add(-1);
        }
        for ( int i = 0 ; i <= n ; i++) {
            myEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = new ArrayList<>();
            edge.addAll(edges.get(i));
            myEdges.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
            myEdges.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
        }
        for (Cost element : myEdges.get(s)) {
            pq.offer(element);
        }
        visited[s] = true;
        while (!pq.isEmpty()) {
            Cost cost = pq.poll();
            if (visited[cost.v] != true) {
                visited[cost.v] = true;
                res.set(cost.v, cost.r);
                for (Cost element : myEdges.get(cost.v)) {
                    if (visited[element.v] != true) {
                        Cost temp = element;
                        temp.r += cost.r;
                        pq.offer(temp);
                    }
                }
            }
        }
        res.remove(s);
        res.remove(0);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.shortestReach(n, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

