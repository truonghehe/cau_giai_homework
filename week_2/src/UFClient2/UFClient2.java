package UFClient2;

import edu.princeton.cs.algs4.StdIn;

public class UFClient2 {
    public static int[] id;
    public static void init(int n) {
        for ( int i = 0 ; i < n ; i ++ ) {
            id[i] = i;
        }
    }
    public static int find(int num) {
        return id[num];
    }
    public static void union( int id1 , int id2) {
        for ( int i =0 ; i < id.length ; i++ ) {
            if ( id[i] == id1) id[i] = id2;
        }
    }
    public static void main( String[] args) {
        int n = StdIn.readInt() , count = n, used = 0;
        id = new int[n];
        init(n);
        int a, b;
        while ( !StdIn.isEmpty()) {
            a = StdIn.readInt();
            b = StdIn.readInt();
            used++;
            int id_a = find(a) , id_b = find(b);
            if ( id_a != id_b) {
                union(id_a , id_b);
                count--;
            }
            if ( count == 1) {
                System.out.println(used);
                break;
            }
        }
        if ( count > 1 ) System.out.println("FAILED");

    }
}
