package collections;

public class Usuario implements Comparable<Usuario> {

	// atributos
	private long idUsuario;
	private String nome;
	private String senha;

	// costrutor
	public Usuario(long idUsuario, String nome, String senha) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
	}

	// getters and setters
	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return this.nome;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nome = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return this.senha;
	}

	public void setSenhaUsuarios(String senhaUsuario) {
		this.senha = senhaUsuario;
	}

	@Override
	public int compareTo(Usuario user) {
		if (this.getIdUsuario() < user.getIdUsuario()) {
			return -1;
		}
		if (this.getIdUsuario() > user.getIdUsuario()) {
			return 1;
		}
		return 0;
	}

}
