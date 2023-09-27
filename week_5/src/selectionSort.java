//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import edu.princeton.cs.algs4.StdIn;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class selectionSort {
    public selectionSort() {
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = StdIn.readInt();
        ArrayList<Integer> array = new ArrayList();

        int i;
        for(i = 0; i < n; ++i) {
            array.add(StdIn.readInt());
        }

        for(i = 0; i < n - 1; ++i) {
            int min = (Integer)array.get(i);
            int pos = -1;

            for(int j = i + 1; j < n; ++j) {
                if ((Integer)array.get(j) < min) {
                    min = (Integer)array.get(j);
                    pos = j;
                }
            }

            if (pos != -1) {
                Collections.swap(array, i, pos);
            }
        }

        for(i = 0; i < n; ++i) {
            PrintStream var10000 = System.out;
            Object var10001 = array.get(i);
            var10000.print(String.valueOf(var10001) + " ");
        }

        long end = System.currentTimeMillis();
        System.out.print("\n" + (end - start));
    }
}

