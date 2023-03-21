import queues.MyQueue;

public class main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.init(1000);

        q.enqueue(23);
        q.enqueue(66);
        System.out.println(q.dequeue());
        q.enqueue(17);
        System.out.println(q.dequeue());
        q.enqueue(32);
        q.enqueue(42);
        System.out.println(q.isFull());
        System.out.println(q.dequeue());
        System.out.println(q.isFull());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.ini);
        System.out.println(q.fim);
    }
}
