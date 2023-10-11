import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class QuickSort {
    private static void sort(int[] a) {
//        StdRandom.shuffle(a);
        int low = 0, high = a.length - 1;
        sort(a, low, high);
    }

    private static void sort(int[] a, int low, int high) {
        if(low >= high) return;
        int j = quicksort(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }
    private static int quicksort(int[] a, int low, int high) {
        int i = low, j = high + 1, pivot = a[low];
        while(true) {
            while (a[++i] < pivot) {
                if (i == high) break;
            }
            while (a[--j] > pivot) {
                if (j == low) break;
            }
            if (j <= i) break;
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }
    private static void exchange(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    public static void main(String[] args) {
        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/1Kints.txt");
        int[] a = in.readAllInts() ;
//        Random random = new Random();
//        for (int i = 0; i < 32000; i++) a[i] = random.nextInt();
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        for (int j : a) System.out.print(j + " ");
        System.out.print("\n" + (end - start));
    }
}
