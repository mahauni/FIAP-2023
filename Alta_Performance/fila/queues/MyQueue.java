package queues;

// Dont use a count to try to verify if it is full
// Dequeue does have a sentinel value -1 when you try to dequeue more 
// than you have. Better way to do this is to throw an error.
// BETTER MEAN IS TO DO IT IF THIS WAS NOT ONLY A DEMONSTRATION
public class MyQueue {
    private int ini;
    private int fim;
    private int N;
    private int dados[];

    public void init(int n) {
        ini = 0;
        fim = 0;
        N = n;
        dados = new int[N];
    }

    public void enqueue(int e) {
        if (!isFull()) {
            dados[fim % N] = e;
            fim++;
        } else {
            System.out.println("Queue full");
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int e = dados[ini % N];
            ini++;
            return e;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (ini == fim)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (ini != fim && ini % N == fim % N)
            return true;
        else
            return false;
    }

    public int first() {
        if (isEmpty()) {
            return -1;
        }
        return dados[ini % N];
    }

    public int getIni() {
        return this.ini;
    }
    public int getFim() {
        return this.fim;
    }
}