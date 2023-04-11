package fila;

import entidades.Mensagem;

public class FilaMensagens {
    private class Node {
        private Mensagem message;
        private Node next;

        public Node(Mensagem message) {
            this.message = message;
        }
    }

    private Node first = null;
    private Node last = null;

    public void enqueue(Mensagem m) {
        Node node = new Node(m);
        if (first == null && last == null) {
            this.first = node;
            this.last = node;    
        }

        this.last.next = node;
        this.last = node;
    }

    public Mensagem dequeue() {
        Node node = this.first;

        if (this.first == null && this.last == null) {
            return null;
        }

        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return node.message;
        }

        this.first = this.first.next;
        node.next = null;

        return node.message;
    }

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        }

        return false;
    }
}
