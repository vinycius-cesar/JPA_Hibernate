package posjavamavenhibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/posjavahibernate?autoReconnect=true";
	private static String password = "admin";
	private static String user ="postgres";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco,user,password);
				connection.setAutoCommit(false);
				System.out.println("conectado");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("erro ao conectar cm o banco");
			
		}
	}
	
	public static Connection getConnection() {
		
		return connection;
		
	}

}
