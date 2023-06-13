package br.com.fiap.connection;



import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;

	//singleton
	private ConnectionFactory() {

	}

	public static Connection conectar() throws SQLException {
		if (conexao == null) {
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(ORACLE);
			comboPooledDataSource.setUser("RM92854");
			comboPooledDataSource.setPassword("240504");
			//número máximo de conexões
			comboPooledDataSource.setMaxPoolSize(20);
			conexao = comboPooledDataSource;
		}
		return conexao.getConnection();
	}
}
