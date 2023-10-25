package New_year_chaos;

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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        List<Integer> check_list = new ArrayList<>(q.size());
        for ( int i = 0 ; i < q.size() ; i++) {
            check_list.add(i+1);
        }
        int count = 0;
        for ( int i = q.size() - 1 ; i >= 0 ; i--) {
            if ( q.equals(check_list)) {
                System.out.println(count);
                break;
            }
            boolean found = false;
            int index = i+1 , index_num = i;
            while ( index_num >= i-2 ) {
                if ( q.get(index_num) == index ) {
                    found = true;
                    break;
                }
                index_num--;
            }
            if (!found) {
                System.out.println("Too chaotic");
                break;
            }

            while (index_num < index - 1) {
                Collections.swap( q , index_num , index_num + 1);
                index_num++;
                count++;
            }

        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
