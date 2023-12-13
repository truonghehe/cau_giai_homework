package Simple_text_editor;

import java.util.Scanner;

public class Solution {
    public static class mystack<Item> {
        private Node<Item> first;
        public mystack() {
            first = null;
        }
        public class Node<Item> {
            private Item data;
            private Node<Item> next;
            public Node(Item data) {
                this.data = data;
            }
        }
        public void push(Item data) {
            if ( first == null ) first = new Node<>(data);
            else {
                Node oldFirst = first;
                first = new Node<>(data);
                first.next = oldFirst;
            }
        }
        public Item pop() {
            if (first.next == null ) {
                first = null;
                return (Item)"";
            }
            else first = first.next;
            return first.data;
        }
    }
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        mystack<String> history = new mystack<>();
        int activityNumber = sc.nextInt();
        String word = "";
        for ( int i = 0 ; i < activityNumber ; i++ ) {
            int act = sc.nextInt();
            switch (act) {
                case 1: {
                    String input = sc.next();
                    word += input;
                    history.push(word);
                    break;
                }
                case 2: {
                    int amountDel = sc.nextInt();
                    String newWord = "";
                    for ( int j = 0 ; j < word.length() - amountDel ; j++) {
                        newWord += word.charAt(j);
                    }
                    word = newWord;
                    history.push(word);
                    break;
                }
                case 3: {
                    int pos = sc.nextInt() - 1 ;
                    System.out.println(word.charAt(pos));
                    break;
                }
                case 4: {
                    word = history.pop();
                }
            }
        }
    }
}
