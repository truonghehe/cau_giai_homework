import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Selection {
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if ( a[min] > a[j]) min = j;
            }
            swap(a, min, i);
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
    public static void main(String[] args) {
        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/1Mints.txt");
//        int[] a = in.readAllInts();
        int[] a = new int[32000];
        for (int i = 0; i < 32000; i++) {
            a[i] = 32000;
        }
        long start = System.currentTimeMillis();
        selectionSort(a);
        long end = System.currentTimeMillis();
        StdArrayIO.print(a);
        System.out.print("\n");
        System.out.println(end - start);
    }
}
