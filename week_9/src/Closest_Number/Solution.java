package Closest_Number;

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
    static List<Integer> aux = new ArrayList<>();

    private static void mergeSort(List<Integer> arr, int l, int r) {
        if (l == r) return;
        int m = l - (l - r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) aux.set(k, arr.get(j++));
            else if (j > r) aux.set(k, arr.get(i++));
            else if (arr.get(i) < arr.get(j)) aux.set(k, arr.get(i++));
            else aux.set(k, arr.get(j++));
        }
        for (int k = l; k <= r; k++) {
            arr.set(k, aux.get(k));
        }

    }


    public static List<Integer> closestNumbers(List<Integer> arr) {
        aux.addAll(arr);
        mergeSort(arr, 0, arr.size() - 1);
        int min = arr.get(1) - arr.get(0);
        for (int i = 1; i < arr.size() - 1; i++) {
            int current = arr.get(i + 1) - arr.get(i);
            if ( current < min) min = current;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == min) {
                res.add(arr.get(i));
                res.add(arr.get(i + 1));
            }
        }
        return res;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result.closestNumbers(arr);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (sc.hasNext()) {
            arr.add(sc.nextInt());
        }
        System.out.println(Result.closestNumbers(arr));
    }
}

