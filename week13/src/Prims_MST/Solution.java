package Prims_MST;
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
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
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
    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        List<List<Cost>> myEdges = new ArrayList<>(n + 1);
        boolean[] mark = new boolean[n + 1];
        int res = 0;
        for ( int i = 0 ; i <= n ; i++) {
            myEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = new ArrayList<>();
            edge.addAll(edges.get(i));
            myEdges.get(edge.get(0)).add(new Cost(edge.get(2), edge.get(1)));
            myEdges.get(edge.get(1)).add(new Cost(edge.get(2), edge.get(0)));
        }
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.offer(new Cost(0, start));
        while (!pq.isEmpty()) {
            Cost u = pq.poll();
            if (mark[u.v]) continue;
            mark[u.v] = true;
            res += u.r;
            for ( int i = 0; i < myEdges.get(u.v).size(); i++) {
                Cost v = myEdges.get(u.v).get(i);
                if (!mark[v.v]) {
                    pq.offer(v);
                }
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

