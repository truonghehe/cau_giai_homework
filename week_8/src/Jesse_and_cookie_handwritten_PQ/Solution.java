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

class MyPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int currSize;

    public MyPriorityQueue(int size){
        pq = (Key[]) new Comparable[size + 1];
        currSize = 0;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    private void resize(int size) {
        Key[] temp = (Key[]) new Object[size];
        for (int i = 1; i <= currSize; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void add(Key key) {
        if (currSize == pq.length - 1) resize(2 * pq.length);

        pq[++currSize] = key;
        swim(currSize);
    }

    public Key remove() {
        Key max = pq[1];
        exch(1, currSize--);
        pq[currSize + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= currSize) {
            int j = 2*k;
            if (j < currSize && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Key peek() {
        return pq[1];
    }

    public int size() {
        return currSize;
    }

    private boolean greater(int i, int j) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int N = A.size();
        MyPriorityQueue<Integer> pqueue = new MyPriorityQueue<>(N);

        for (int i = 0; i < N; i++) {
            pqueue.add(A.get(i));
        }

        int ans = 0;
        while (pqueue.size()>1) {
            Integer temp1 = pqueue.remove();
            Integer temp2 = pqueue.remove();

            if (temp1 >= k) {
                return ans;
            }

            Integer temp3 = temp1 + 2 * temp2;
            pqueue.add(temp3);
            ans++;
        }

        return (pqueue.peek() >= k) ? ans : -1;
    }
}

public class Bonus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}