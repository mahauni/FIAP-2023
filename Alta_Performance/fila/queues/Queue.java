package queues;

public class Queue {
    private class Node {
        private int data;
        private Node next;

        public Node(int message) {
            this.data= message;
        }
    }

    private Node first = null;
    private Node last = null;

    public void enqueue(int m) {
        Node node = new Node(m);
        if (first == null && last == null) {
            this.first = node;
            this.last = node;    
        }

        this.last.next = node;
        this.last = node;
    }

    public int dequeue() {
        Node node = this.first;

        if (this.first == null && this.last == null) {
            // return null;
            return -1;
        }

        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return node.data;
        }

        this.first = this.first.next;
        node.next = null;

        return node.data;
    }

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        }

        return false;
    }
}
