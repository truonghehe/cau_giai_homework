package Java_String_Reverse;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String res=new StringBuilder(A).reverse().toString();
        String rev=(A.equals(res))?"Yes":"No";
        System.out.print(rev);
    }
}
