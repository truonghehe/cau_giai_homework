package counting_element;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class counting {
    static List<String> text = new ArrayList<>();
    static List<Integer> apppear = new ArrayList<>();

    public static void check() {
        for (int i = 0; i < text.size() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < text.size(); j++) {
                if (text.get(i).equals(text.get(j))) {
                    count++;
                    apppear.set(j, 0);
                }
            }
            if (apppear.get(i) != 0) apppear.set(i, count);
        }
    }

    public static void print() {
        for (int i = 0; i < text.size(); i++) {
            if (apppear.get(i) != 0) {
                System.out.println("[" + text.get(i) + ", " + apppear.get(i) + "]");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        FileReader fr = new FileReader("1KInts.txt");
        while (sc.hasNext()) {
            text.add(sc.next());
            apppear.add(-1);
        }

        check();
        print();
    }
}
