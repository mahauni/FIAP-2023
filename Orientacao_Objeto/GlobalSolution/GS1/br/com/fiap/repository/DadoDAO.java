package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connection.ConnectionFactory;
import br.com.fiap.model.Dado;

public class DadoDAO {

	private Connection conexao;

	public DadoDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Dado dado) {
		String sql = "insert into dados(nutrientes, umidade, ph, salinidade, acoes, sugestoes, aumento_previsto, usuario) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, dado.getNutrientes());
			stmt.setFloat(2, dado.getUmidade());
			stmt.setFloat(3, dado.getPh());
			stmt.setFloat(4, dado.getSalinidade());
			stmt.setString(5, dado.getAcoes());
			stmt.setString(6, dado.getSugestoes());
			stmt.setFloat(7, dado.getAumento_previsto());
			stmt.setString(8, dado.getUsuario());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Dado> selectAll() {
		List<Dado> dados = new ArrayList<Dado>();
		String sql = "select * from dados";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Dado dado = new Dado();
				dado.setId(rs.getInt("id"));
				dado.setNutrientes(rs.getString("nutrientes"));
				dado.setUmidade(rs.getFloat("umidade"));
				dado.setPh(rs.getFloat("ph"));
				dado.setSalinidade(rs.getFloat("salinidade"));
				dado.setAcoes(rs.getString("acoes"));
				dado.setSugestoes(rs.getString("sugestoes"));
				dado.setAumento_previsto(rs.getFloat("aumento_previsto"));
				dado.setUsuario(rs.getString("usuario"));
				dados.add(dado);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dados;
	}

	public Dado selectById(int id) throws SQLException {
		Dado dado = null;
		String sql = "select * from dados where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dado = new Dado();
				dado.setId(rs.getInt("id"));
				dado.setNutrientes(rs.getString("nome"));
				dado.setUmidade(rs.getFloat("umidade"));
				dado.setPh(rs.getFloat("ph"));
				dado.setSalinidade(rs.getFloat("salinidade"));
				dado.setAcoes(rs.getString("acoes"));
				dado.setSugestoes(rs.getString("sugestoes"));
				dado.setAumento_previsto(rs.getFloat("aumento_previsto"));
				dado.setUsuario(rs.getString("usuario"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dado;
	}

	public void delete(int id) {
		String sql = "delete from dados where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Dado dado) {
		String sql = "update dados set nutrientes=?, umidade=?, ph=?, salinidade=?, acoes=?, sugestoes=?, aumento_previsto=?, usuario=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, dado.getNutrientes());
			stmt.setFloat(2, dado.getUmidade());
			stmt.setFloat(3, dado.getPh());
			stmt.setFloat(4, dado.getSalinidade());
			stmt.setString(5, dado.getAcoes());
			stmt.setString(6, dado.getSugestoes());
			stmt.setFloat(7, dado.getAumento_previsto());
			stmt.setString(8, dado.getUsuario());
			stmt.setInt(9, dado.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
