package Closest_number;

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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        int minimum = Math.abs(arr.get(1) - arr.get(0)), dif = 0;
        List<Integer> dif_list = new ArrayList<>();
        dif_list.add(minimum);
        for ( int i = 2 ; i < arr.size() ; i++) {
            dif = Math.abs(arr.get(i) - arr.get(i-1));
            dif_list.add(dif);
            if ( dif < minimum ) minimum = dif;
        }
        List<Integer> res = new ArrayList<>();
        for ( int i = 1 ; i < arr.size() ; i++) {
            if ( dif_list.get(i-1) == minimum ) {
                res.add(arr.get(i-1));
                res.add(arr.get(i));
            }
        }
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

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
