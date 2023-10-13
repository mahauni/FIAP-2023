import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ABBClientes {

	private class ARVORE {
		Cliente dado;
		ARVORE dir;
		ARVORE esq;
	}

	public ARVORE root = null;

	public void mostra(ARVORE p) {
		if (p != null) {
			mostra(p.esq);
			System.out.println(" " + p.dado);
			mostra(p.dir);
		}
	}

	public int conta(ARVORE p, int cont) {
		if (p != null) {
			cont++;
			cont = conta(p.esq, cont);
			cont = conta(p.dir, cont);
		}
		return cont;
	}

	public ARVORE inserir(ARVORE p, Cliente info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info.getSaldo() < p.dado.getSaldo()) {
			p.esq = inserir(p.esq, info);
		} else {
			p.dir = inserir(p.dir, info);
		}
		return p;
	}

	public ARVORE removeValor(ARVORE p, float info) {
		if (p != null) {
			if (info == p.dado.getNumConta()) {
				if (p.esq == null && p.dir == null)
					return null;
				else {
					if (p.esq == null)
						return p.dir;
					else if (p.dir == null)
						return p.esq;
					else {
						ARVORE aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else { // procura dado a ser removido na ABB
				if (info < p.dado.getNumConta())
					p.esq = removeValor(p.esq, info);
				else
					p.dir = removeValor(p.dir, info);
			}
		}
		return p;
	}

	private void getAllClients(ARVORE p, List<Cliente> clientes, float info) {
		if (p == null) {
			return;
		}

		if (p.dado.getSaldo() >= info) {
			clientes.add(p.dado);
		}

		if (p.dado.getSaldo() < info) {
			getAllClients(p.dir, clientes, info);
		}

		if (p.dado.getSaldo() >= info) {
			getAllClients(p.dir, clientes, info);
			getAllClients(p.esq, clientes, info);
		}
	}

	public List<Cliente> listaOfertas(ARVORE p, float info) {
		List<Cliente> clientes = new ArrayList<>();

		getAllClients(p, clientes, info);

		// precisa fazer o sort aqui por causa de um problema de quando vai busca todos.
		clientes.sort(new Comparator<Cliente>() {
			@Override
			public int compare(Cliente o1, Cliente o2) {
				return Float.compare(o2.getSaldo(), o1.getSaldo());
			}
		});

		return clientes;
	}

	public Cliente findClienteByNum(ARVORE p, int numConta) {
		if (p != null) {
			if (p.dado.getNumConta() == numConta) {
				return p.dado;
			}
			findClienteByNum(p.esq, numConta);
			findClienteByNum(p.dir, numConta);
		}
		return null;
	}

	public ARVORE updateCliente(ARVORE p, int numConta, float novoSaldo) {
		// precisa dar delete
		Cliente c = findClienteByNum(this.root, numConta);
		if (c != null) {
			p = removeValor(p, c.getSaldo());
			c.setSaldo(novoSaldo);
			p = inserir(p, c);
		}

		return p;
	}
}
