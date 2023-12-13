package Balanced_brackets;

import java.io.*;
import java.util.stream.*;
import java.util.Stack;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> braces = new Stack<>();
        for ( int i = 0 ; i < s.length() ; i++ )  {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' ) braces.push(s.charAt(i));
            else {
                if ( braces.size() == 0 ) return "NO";
                else if (s.charAt(i) == '}' && braces.peek() == '{' ) braces.pop();
                else if (s.charAt(i) == ']' && braces.peek() == '[' ) braces.pop();
                else if (s.charAt(i) == ')' && braces.peek() == '(' ) braces.pop();
                else return "NO";
            }
        }
        if ( braces.size() == 0 ) return "YES";
        else return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
