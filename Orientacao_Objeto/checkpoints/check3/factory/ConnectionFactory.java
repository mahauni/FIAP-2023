package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	public Connection connection() {
		try {
			return DriverManager.getConnection(ORACLE,"RM92854", "240504");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
	}
}
