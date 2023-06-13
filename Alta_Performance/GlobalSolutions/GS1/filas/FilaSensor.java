package filas;

import entidades.Sensor;

public class FilaSensor {

	private class NO {
		Sensor dado;
		NO prox;
	}

	NO ini, fim;

	public FilaSensor() {
		ini = fim = null;
	}

	public boolean isEmpty() {
		return ini == null && fim == null;
	}

	public void enqueue(Sensor elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (isEmpty())
			ini = novo;
		else
			fim.prox = novo;
		fim = novo;
	}

	public Sensor dequeue() {
		if (!isEmpty()) {
			Sensor v = ini.dado;
			ini = ini.prox;
			if (ini == null)
				fim = null;
			return v;
		}
		return null;
	}

	public Sensor first() {
		return (ini.dado);
	}

	public void get(int n) {
		NO node = ini;
		while (n != 0 && node != null) {
			node = node.prox;
			n--;
		}

		if (n == 0) {
			System.out.println(node.dado);
		} else {
			System.out.println("Sensor não encontrado");
		}
	}

	public void traverse() {
		NO node = ini;
		while (node != null) {
			System.out.println(node.dado);
			node = node.prox;
		}
	}
}
