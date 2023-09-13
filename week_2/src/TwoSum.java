import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class TwoSum {
    public static void main( String[] args) {
        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/4Kints.txt");
        int[] array = in.readAllInts();
        Arrays.sort(array);
        int count = 0;
        for ( int i = 0 ; i < array.length -2 ; i++) {
            int find = -array[i];
            int l = i , r = array.length -1;
            while ( l <= r ) {
                int middle = (l + r)/2;
                    if ( array[middle] == find ) { count++; break; }
                    else if ( array[middle] > find ) r= middle-1;
                    else l = middle + 1;
                }
        }
        System.out.println(count);
    }
}
