package fila;

import entidades.Mensagem;

public class FilaMensagens {
    private int ini;
    private int fim;
    private int N;
    private Mensagem[] dados;

    public void init(int n) {
        ini = 0;
        fim = 0;
        N = n;
        dados = new Mensagem[N];
    }

    public void enqueue(Mensagem m) {
        if (!isFull()) {
            dados[fim % N] = m;
            fim++;
        } else {
            System.out.println("Queue full");
        }
    }

    public Mensagem dequeue() {
        if (!isEmpty()) {
            Mensagem m = dados[ini % N];
            ini++;
            return m;
        }
        return null;
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

    public Mensagem first() {
        if (isEmpty()) {
            return null;
        }
        return dados[ini % N];
    }
}
