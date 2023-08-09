package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Produto produto) {
		try {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, idCategoria) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);


			 stmt.setString(1, produto.getNome());
			 stmt.setString(2, produto.getDescricao());
			 stmt.setInt(3, produto.getIdCategoria());
			 stmt.execute();
			 stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM ESG WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> selectAll() {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM ESG";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public Produto selectById(int id) {
		Produto produto = null;
		String sql = "SELECT * FROM ESG WHERE ID=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				produto = new Produto();
				produto.setIdProduto(rs.getInt("IDPRODUTO"));
				produto.setDescricao(rs.getString("DESCRICAO"));
				produto.setNome(rs.getString("NOME"));
				produto.setIdCategoria(rs.getInt("IDCATEGORIA"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	// isso daqui esta errado!!
	public List<Produto> listarProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();

		try {
			String sql = "SELECT idProduto,nome, descricao, idCategoria FROM PRODUTO";
			PreparedStatement stmt = connection.prepareStatement(sql);
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}
}