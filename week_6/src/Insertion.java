import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdRandom;

class Insertion {
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
                else break;
            }
        }
    }
    public static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void main(String[] args) {
        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/1Mints.txt");
        int[] a = new int[32000];
        for (int i = 0; i < 32000; i++) {
            a[i] = 0;
        }
        long start = System.currentTimeMillis();
        insertionSort(a);
        long end = System.currentTimeMillis();
        StdArrayIO.print(a);
        System.out.println("\n");
        System.out.println(end - start);
    }
}