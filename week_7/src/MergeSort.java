import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Random;

public class MergeSort {
    public static void mergeSort (int[] a) {
        int[] aux = new int[a.length];
        for (int k = 0; k < a.length; k++) aux[k] = a[k];
        int low = 0, high = a.length - 1;
        sort(a, aux, low, high);
    }

    private static void sort(int[] a, int[] aux, int low,int high) {
        if (high <= low) return;
        int mid = low - (low - high)/2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) aux[k] = a[k];
        int i = low, j = mid + 1;
        for ( int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
//        while (!StdIn.isEmpty()) {
//            a.add(StdIn.readInt());
//        }
//        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/1Mints.txt");
        int[] a = new int[32000];
        Random random = new Random();
        for (int i = 0; i < 32000; i++) a[i] = random.nextInt(32000);
        long start = System.currentTimeMillis();
        mergeSort(a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n" + (end - start));
    }
}
