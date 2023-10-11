package QuicksortInPlace;
import java.io.*;
import java.util.*;

public class Solution {

    private static void divide(int[] a) {
        int low = 0, high = a.length - 1;
        divide(a, low, high);
    }
    private static int quickSort(int[] a, int low, int high) {
        int pivot = high, i = low;
        for (int j = low; j < high; j++) {
            if (a[j] < a[pivot]) {
                exchange(a, i, j);
                i++;
            }
        }
        exchange(a, i, pivot);
        return i;
    }
    private static void divide(int[] a, int low, int high) {
        if (low >= high) return;
        int j = quickSort(a, low, high);
        for (int k = 0; k < a.length; k++) System.out.print(a[k] + " ");
        System.out.print("\n");
        divide(a, low, j - 1);
        divide(a, j + 1, high);
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        divide(a);
    }

}
