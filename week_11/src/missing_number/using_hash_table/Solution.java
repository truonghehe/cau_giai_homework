package missing_number.using_hash_table;

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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapA = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (mapA.containsKey(arr.get(i))) {
                mapA.replace(arr.get(i), mapA.get(arr.get(i)) + 1);
            } else {
                mapA.put(arr.get(i), 1);
            }
            if (mapB.containsKey(brr.get(i))) {
                mapB.replace(brr.get(i), mapB.get(brr.get(i)) + 1);
            } else {
                mapB.put(brr.get(i), 1);
            }
        }
        for (int i = arr.size(); i < brr.size(); i++) {
            if (mapB.containsKey(brr.get(i))) {
                mapB.replace(brr.get(i), mapB.get(brr.get(i)) + 1);
            } else {
                mapB.put(brr.get(i), 1);
            }
        }
        for (Integer element : brr) {
            if ((!mapA.containsKey(element) || !mapA.get(element).equals(mapB.get(element))) && !res.contains(element)) {
                res.add(element);
            }
        }
        Collections.sort(res);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("src/missing_number/using_hash_table/console.txt")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

