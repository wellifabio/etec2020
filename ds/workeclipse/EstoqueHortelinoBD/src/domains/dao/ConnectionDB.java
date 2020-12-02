package domains.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionDB {
	//Atributos para Conexão com o Banco de dados
	private static String dns = "jdbc:mysql://localhost:3306/HortelinoEstoque";
	private static String usuario = "root";
	private static String senha = "";
	private static Connection con;
	
	//Método que faz a conexão efetivamente
	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed()) {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(dns,usuario,senha);
			}
			return con;
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no BD: "+ e);
			return null;
		}
	}
}
