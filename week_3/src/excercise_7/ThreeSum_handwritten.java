package excercise_7;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum_handwritten {
    public static List<Integer> ls = new ArrayList<>();

    private static void ThreeSum() {
        for (int i = 0; i < ls.size() - 2; i++) {
            int a = ls.get(i);
            int bid = i + 1;
            int cid = ls.size() - 1;
            while (bid < cid) {
                int b = ls.get(bid);
                int c = ls.get(cid);
                if (a + b + c == 0) {
                    System.out.println("[" + a + ", " + b + ", " + c + "]");
                    bid++;
                }
                else if (a + b + c > 0) cid--;
                else bid++;

            }
        }
    }
    public static void main(String[] args) {
        In in = new In("/Users/chuongdz/Desktop/algorithms/documents/algs4-data/4KInts.txt");
        while (!in.isEmpty()) {
            ls.add(in.readInt());
        }
        Collections.sort(ls);
        ThreeSum();
    }

}
