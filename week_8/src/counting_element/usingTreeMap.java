package counting_element;

import java.util.*;

public class usingTreeMap {

    public static List<String> text = new ArrayList<>();
    public static Map<String, Integer> counter = new TreeMap<>();

    public static void count() {
        for (int i = 0; i < text.size(); i++) {
            if (!counter.containsKey(text.get(i))) counter.put(text.get(i), 1);
            else {
                counter.put(text.get(i), counter.get(text.get(i)) + 1);
            }
        }
    }

    public static void print() {
        System.out.println(counter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            text.add(sc.next());
        }
        count();
        print();
    }
}
