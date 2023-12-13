package Three_sum;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Three_sum {
    public static void main( String[] args) {
        In in = new In ("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/4KInts.txt");
        int[] array = in.readAllInts();
        Arrays.sort(array);
        for ( int i = 0 ; i < array.length - 2 ; i ++) {
            for ( int j = array.length - 1 ; j > i ; j--) {
                int find = - ( array[i] + array[j]);
                int l = i+1 , r = j - 1, middle;
                while ( l <= r) {
                    middle = (r + l)/2;
                    if ( array[middle] == find) { System.out.println("[" + array[i] + "," + array [j] + "," + find + "]"); break; }
                    else if ( array[middle] < find ) l = middle + 1;
                    else r = middle -1;
                }
            }
        }
    }
}
