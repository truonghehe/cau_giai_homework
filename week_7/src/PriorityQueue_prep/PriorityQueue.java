package PriorityQueue_prep;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class PriorityQueue {
    public Node first;
    public Node last;

    public PriorityQueue() {
        this.first = null;
        this.last = null;
    }
    public void insert(int data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        }
        else {
            last.next = new Node(data);
            last = last.next;
        }
    }
    public int deleteMin() {
        int min = this.first.data;
        Node temp = first;
        while (temp != null) {
            if (min > temp.data) min = temp.data;
            temp = temp.next;
        }
        temp = first;
        while (temp.next != null) {
            if (temp.next.data == min) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        if (temp.data == min) {
            temp = null;
        }
        return min;
    }
}
