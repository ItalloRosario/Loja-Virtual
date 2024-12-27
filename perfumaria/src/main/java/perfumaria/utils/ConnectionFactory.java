package perfumaria.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/exemplomvc";
			String usuario = "root";
			String senha = "15082004";
			
			Connection retorno = DriverManager.getConnection(url,usuario,senha);
			
			return retorno;

		}catch(SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException("Erro ao abrir conexão", ex);

		}catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException("Erro ao registrar driver do JDBC", ex);

		}
	}
}

