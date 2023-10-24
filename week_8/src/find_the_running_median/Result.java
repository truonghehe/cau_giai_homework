package find_the_running_median;

import java.util.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Double> minPQ = new PriorityQueue<>(a.size() / 2 + 1);
        PriorityQueue<Double> maxPQ = new PriorityQueue<>(a.size() / 2 + 1, Collections.reverseOrder());
        List<Double> ans = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) {
            //maxPQ contains small value, minPQ contains big value
            if (maxPQ.peek() == null || a.get(i) <= maxPQ.peek()) {
               maxPQ.offer(Double.valueOf(a.get(i)));
            }
            else {
                minPQ.offer(Double.valueOf(a.get(i)));
            }

            //balance
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            }
            else if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }

            if (maxPQ.size() == minPQ.size()) {
                ans.add((maxPQ.peek() + minPQ.peek()) / 2);
            } else {
                ans.add(maxPQ.peek());
            }
        }
        return ans;
    }

}