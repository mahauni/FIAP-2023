package queues;

public class QueueString {
    private int ini;
    private int fim;
    private int N;
    private String dados[];

    public void init(int n) {
        ini = 0;
        fim = 0;
        N = n;
        dados = new String[N];
    }

    public void enqueue(String e) {
        if (!isFull()) {
            dados[fim % N] = e;
            fim++;
        } else {
            System.out.println("Queue full");
        }
    }

    public String dequeue() {
        if (!isEmpty()) {
            String e = dados[ini % N];
            ini++;
            return e;
        }
        return "";
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

    public String first() {
        if (isEmpty()) {
            return "";
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
