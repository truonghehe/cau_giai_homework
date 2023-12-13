package Queue_using_two_stacks;

import java.util.Scanner;

public class Solution {

    public static class queue<Item> {
        private Node<Item> first, last;
        public queue() {
            this.first = null;
            this.last = null;
        }
        public void Enqueue(Item data) {
            if ( first == null ) {
                first = new Node<>(data);
                last = first;
            }
            else {
                Node<Item> oldLast = last;
                last = new Node<Item> (data);
                oldLast.next = last;
            }
        }
        public void Dequeue () {
            if ( first == last ) first = null;
            else first = first.next;
        }
        public Item peek() {
            return first.data;
        }
        public class Node<Item> {
            private Item data;
            private Node<Item> next;
            public Node(Item data) {
                this.data = data;
                this.next = null;
            }
        }
    }
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        queue<Integer> myQueue = new queue<>();
        for ( int i = 0 ; i < n ; i++ ) {
            int action = sc.nextInt();
            if (action == 1 ) {
                myQueue.Enqueue(sc.nextInt());
            }
            else if (action == 2 ) {
                myQueue.Dequeue();
            }
            else if (action == 3 ) {
                System.out.println(myQueue.peek());
            }
        }
    }
}
