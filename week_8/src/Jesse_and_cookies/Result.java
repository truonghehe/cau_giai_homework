package Jesse_and_cookies;

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
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);
        int count = 0, first, second;
        if (pq.peek() == null)  {
            return -1;
        }
        else {
            while (pq.peek() < k) {
                if (pq.peek() != null) first = pq.poll();
                else return -1;
                if (pq.peek() != null) second = pq.poll();
                else return -1;
                pq.add(first + second * 2);
                count++;
            }
        }
        return count;
    }

}