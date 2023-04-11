import queues.*;

public class main {
    public static void main(String[] args) {
        // ProfQueue q = new ProfQueue();
        MyQueue q = new MyQueue();
        q.init(2);

        q.enqueue(23);
        q.enqueue(66);
        System.out.println(q.dequeue());
        q.enqueue(17);
        System.out.println(q.dequeue());
        q.enqueue(32);
        q.enqueue(42);
        System.out.println(q.isFull());
        System.out.println("Valor retirado: " + q.dequeue());
        System.out.println(q.isFull());
        System.out.println("Valor do topo: " + q.first());
        System.out.println("Valor retirado: " + q.dequeue());
        System.out.println("Valor retirado: " + q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.getIni());
        System.out.println(q.getFim());
    }
}
