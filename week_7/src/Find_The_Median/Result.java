package Find_The_Median;
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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int low = 0, high = arr.size() - 1;
        return arr.get(findMedian(arr, low, high));
    }

    private static int findMedian(List<Integer> arr, int low, int high) {
        int i = low, j = high + 1, pivot = arr.get(low);
        while(true) {
            while (arr.get(++i) < pivot) {
                if (i == high) break;
            }
            while (arr.get(--j) > pivot) {
                if (j == low) break;
            }
            if (i >= j) break;
            exchange (arr, i, j);
        }
        exchange(arr, low, j);
        if (j == arr.size()/2) return j;
        else if ( j > arr.size()/2) return findMedian(arr, low, j - 1);
        else return findMedian(arr, j + 1, high);
    }
    private static void exchange(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

