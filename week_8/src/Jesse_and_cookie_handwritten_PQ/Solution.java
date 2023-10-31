package Jesse_and_cookie_handwritten_PQ;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class myPriorityQueue {
    public int[] a = new int[1000000];
    public int n = 0;

    public int peek() {
        if (n == 0) return -9999;
        else return a[1];
    }

    public int poll() {
        int temp = a[1];
        swap(1, n);
        n--;
        sink(1);
        return temp;
    }

    public void sink(int pos) {
        while (pos * 2 < n) {
            int j = pos * 2;
            if (j + 1 >= n) {
                if (a[j] < a[pos]) swap(j, pos);
                break;
            } else {
                if (a[j] > a[j + 1] && a[pos] > a[j + 1]) {
                    swap(pos, j + 1);
                    pos = j + 1;
                }
                else if (a[j] < a[j + 1] && a[pos] > a[j]) {
                    swap(pos, j);
                    pos = j;
                }
            }
        }
    }

    public void swim(int pos) {
        while (pos > 1) {
            if (a[pos] < a[pos / 2]) {
                swap(pos, pos / 2);
            }
            pos /= 2;
        }
    }
    public void add(int x) {
        a[++n] = x;
        swim(n);
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
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
        myPriorityQueue pq = new myPriorityQueue();
        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
        }
        int count = 0;
        Integer first, second;
        if (pq.peek() == -9999)  {
            return -1;
        }
        else {
            while (pq.peek() < k) {
                if (pq.peek() != -9999) first = pq.poll();
                else return -1;
                if (pq.peek() != -9999) second = pq.poll();
                else return -1;
                pq.add(first + second * 2);
                count++;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int k = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.cookies(k, A);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(Result.cookies(k, arr));
    }
}

