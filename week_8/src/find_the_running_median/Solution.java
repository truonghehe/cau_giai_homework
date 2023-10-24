package find_the_running_median;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Double> result = Result.runningMedian(a);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(sc.nextInt());
        }
        List<Double> ans = new ArrayList<>(n);
        ans = Result.runningMedian(ls);
        System.out.println(ans);
    }
}
