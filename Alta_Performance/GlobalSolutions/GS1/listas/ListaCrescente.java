package listas;

import entidades.Sensor;
import filas.FilaSensor;

public class ListaCrescente {

	private class NO {
		Sensor dado;
		NO prox;
	}

	private NO lista = null;

	public void insere(Sensor elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getUmidade() < lista.dado.getUmidade()) {
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getUmidade() < novo.dado.getUmidade())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	}

	public boolean remove(Sensor valor) {
		boolean achou = false;
		if (lista != null) {
			if (valor == lista.dado) {
				achou = true;
				lista = lista.prox;
			} else {
				NO aux = lista;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado != valor)
						aux = aux.prox;
					else {
						achou = true;
						aux.prox = aux.prox.prox;
					}
				}
			}
		}
		return achou;
	}

	public int contaNos() {
		int cont=0;
		NO aux = lista;
		while (aux!=null) {
			cont++;
			aux=aux.prox;
		}
		return cont;
	}

	public Sensor procura(String coord) {
		NO aux = lista;
		while (aux != null && !aux.dado.getCoordenada().equals(coord)) {
			aux = aux.prox;
		}

		if (aux == null) {
			System.out.println("Sensor não encontrado nessa coordenada!");
			return null;
		}
		return aux.dado;
	}

	public void verificar(FilaSensor sensores) {
		NO aux = lista;
		int negativos;
		while (aux != null) {
			System.out.println("----------------------");
			System.out.println("Coordenada do sensor: " + aux.dado.getCoordenada());
			negativos = 0;
			System.out.println("Diagnostico do pH:");
			if (!aux.dado.getPhPrint()) {
				negativos++;
			}
			System.out.println();
			System.out.println("Diagnostico da salinidade:");
			if (!aux.dado.getSalinidadePrint()) {
				negativos++;
			}
			System.out.println();
			System.out.println("Diagnostico da umidade");
			if (!aux.dado.getUmidadePrint()) {
				negativos++;
			}
			System.out.println();
			System.out.println("Diagnostico dos nutrientes:");
			for (boolean neg : aux.dado.getNutrientesPrint()) {
				if (!neg) {
					negativos++;
				}
			}
			System.out.println();
			System.out.println("O sensor " + aux.dado.getId() + " Tem " + negativos + " problema(s)");
			if (negativos > 1) {
				sensores.enqueue(aux.dado);
			}
			System.out.println();
			aux = aux.prox;
		}
	}


	public void apresenta() {
		NO aux = lista;
		System.out.println("\n *** LISTA ***");
		while (aux != null) {
			System.out.println("\t " + aux.dado);
			aux = aux.prox;
		}
	}
}

