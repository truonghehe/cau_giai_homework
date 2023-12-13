package Java_Map;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, String> phoneBook = new HashMap<>();
        while (n > 0) {
            String name = sc.nextLine();
            String phoneNumber = sc.nextLine();
            phoneBook.put(name, phoneNumber);
            n--;
        }
        while (sc.hasNext()) {
            String get = sc.nextLine();
            if (phoneBook.containsKey(get)) {
                System.out.println(get+ "=" + phoneBook.get(get));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
