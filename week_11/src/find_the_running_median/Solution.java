package find_the_running_median;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    private static class pairs {
        int number;
        int index;

        public pairs(int index, int number) {
            this.number = number;
            this.index = index;
        }

        public static int compare(Object o1, Object o2) {
            pairs p1 = (pairs) o1;
            pairs p2 = (pairs) o2;
            if (Integer.compare(p1.number, p2.number) == 0) {
                return Integer.compare(p1.index, p2.index);
            } else return Integer.compare(p1.number, p2.number);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        TreeSet<pairs> lowerHalf = new TreeSet<>((a1, a2) -> pairs.compare(a2, a1));
        TreeSet<pairs> upperHalf = new TreeSet<>(pairs::compare);
        List<Double> ans = new ArrayList<>();
        int count = 0;
        for (int num : a) {

            if (lowerHalf.isEmpty() || num <= lowerHalf.first().number) {
                pairs tmp = new pairs(count++, num);
                lowerHalf.add(tmp);
            } else {
                pairs tmp = new pairs(count++, num);
                upperHalf.add(tmp);
            }

            // Balance the sets
            while (lowerHalf.size() > upperHalf.size() + 1) {
                upperHalf.add(lowerHalf.pollFirst());
            }
            while (upperHalf.size() > lowerHalf.size()) {
                lowerHalf.add(upperHalf.pollFirst());
            }

            // Calculate and print the median
            double median;
            if (lowerHalf.size() == upperHalf.size()) {
                median = (lowerHalf.first().number + upperHalf.first().number) / 2.0;
            } else {
                median = lowerHalf.first().number;
            }

            ans.add(median);
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

