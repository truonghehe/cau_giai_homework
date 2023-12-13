package Kruskal;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int u, v, w;

    public Edge(int vertex1, int vertex2, int weight) {
        u = vertex1;
        v = vertex2;
        w = weight;
        if (u > v) {
            int tmp = u;
            u = v;
            v = tmp;
        }
    }

    @Override
    public int compareTo(Edge o) {
        if (w < o.w) return -1;
        if (w > o.w) return 1;
        if (u < o.u) return -1;
        if (u > o.u) return 1;
        return Integer.compare(v, o.v);
    }
}

class UF {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components

    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make root of smaller rank point to root of larger rank
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

//    private void validate(int p) {
//        int n = parent.length;
//        if (p < 0 || p >= n) {
//            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
//        }
//    }
}
class Solution {
    private static int kruskals(int n, PriorityQueue<Edge> pq) {
        int minMst = 0;
        UF unf = new UF(n + 1);
        for (int i = 1; i < n; i++) {
            Edge min = pq.poll();
            while (!pq.isEmpty() && unf.connected(min.u, min.v)) {
                min = pq.poll();
            }
            unf.union(min.u, min.v);
            minMst += min.w;
        }

        return minMst;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfVertex = sc.nextInt();
        int numOfEdges = sc.nextInt();
        int res = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < numOfEdges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            Edge temp = new Edge(from, to, weight);
            pq.offer(temp);
        }
        System.out.println(kruskals(numOfVertex, pq));
    }
}