package br.com.fiap.testes;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.model.Dado;
import br.com.fiap.repository.DadoDAO;

public class TestaUsuarioDAO {

	public static void main(String[] args) throws SQLException {

		DadoDAO dao = new DadoDAO();
/*
		Dado emerson = new Dado("Emerson", "emerson@gmail.com", "123456");
		Dado adriane = new Dado("Adriane", "adriane@gmail.com", "654321");

		dao.insert(emerson);
		dao.insert(adriane);
		

		List<Dado> dados = dao.selectAll();
		for (Dado dado : dados) {
			System.out.println(dado.getId());
			System.out.println(dado.getNome());
			System.out.println(dado.getEmail());
			System.out.println(dado.getData());
		}
	
		Dado dado = dao.selectById(1);

			System.out.println(dado.getId());
			System.out.println(dado.getNome());
			System.out.println(dado.getEmail());
			System.out.println(dado.getData());
 */
	}
}