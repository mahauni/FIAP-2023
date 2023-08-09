package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int idCategoria;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria() {
	}
	
	public Categoria(int idCategoria, String nome, List<Produto> produtos) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.produtos = produtos;
	}
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		produtos.add(produto);
	}
}
