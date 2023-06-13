package br.com.fiap.model;

public class Dado {
	private int id;
	private String usuario;
	private String nutrientes;
	private float umidade;
	private float ph;
	private float salinidade;
	private String acoes;
	private String sugestoes;
	private float aumento_previsto;

	public Dado() {
	}

	public Dado(String usuario, String nutrientes, float umidade, float ph, float salinidade, String acoes, String sugestoes, float aumento_previsto) {
		this.usuario = usuario;
		this.nutrientes = nutrientes;
		this.umidade = umidade;
		this.ph = ph;
		this.salinidade = salinidade;
		this.acoes = acoes;
		this.sugestoes = sugestoes;
		this.aumento_previsto = aumento_previsto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNutrientes() {
		return nutrientes;
	}

	public void setNutrientes(String nutrientes) {
		this.nutrientes = nutrientes;
	}

	public float getUmidade() {
		return umidade;
	}

	public void setUmidade(float umidade) {
		this.umidade = umidade;
	}

	public float getPh() {
		return ph;
	}

	public void setPh(float ph) {
		this.ph = ph;
	}

	public float getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(float salinidade) {
		this.salinidade = salinidade;
	}

	public String getAcoes() {
		return acoes;
	}

	public void setAcoes(String acoes) {
		this.acoes = acoes;
	}

	public String getSugestoes() {
		return sugestoes;
	}

	public void setSugestoes(String sugestoes) {
		this.sugestoes = sugestoes;
	}

	public float getAumento_previsto() {
		return aumento_previsto;
	}

	public void setAumento_previsto(float aumento_previsto) {
		this.aumento_previsto = aumento_previsto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Dado{" +
				"id=" + id +
				", usuario='" + usuario + '\'' +
				", nutrientes='" + nutrientes + '\'' +
				", umidade=" + umidade +
				", ph=" + ph +
				", salinidade=" + salinidade +
				", acoes='" + acoes + '\'' +
				", sugestoes='" + sugestoes + '\'' +
				", aumento_previsto=" + aumento_previsto +
				'}';
	}
}