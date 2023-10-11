package Quicksort1_Partition;
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
public class Result {
        /*
         * Complete the 'quickSort' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> quickSort(List<Integer> arr) {
            // Write your code here
            int pivot = arr.get(0), i = 0, j = arr.size();
            while (true) {
                while (arr.get(++i) < pivot) {
                    if (i == arr.size() - 1) break;
                }
                while (arr.get(--j) > pivot) {
                    if (j == 0) break;
                }
                if ( i >= j) break;
                exchange(arr, i, j);
            }
            exchange(arr, 0, j);
            return arr;
        }

    private static void exchange(List<Integer> arr, int i, int j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
    }
}
