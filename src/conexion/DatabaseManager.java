package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static Connection databaseConnection;
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "PRESENCIAL";
	private static String CLAVE = "PRESENCIAL";
	
	static {
		databaseConnection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[Drive Oracle] Librería referenciada correctamente");
	
			// Tratando de darle el valor a la variable de conexion 
			try { 
				
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
				System.out.println("[DB] Conexión creada con éxito");
				
			} catch (SQLException e) {
				System.err.println("No logramos instanciar una conexión!!");
				e.printStackTrace();
			}
			
		} catch(ClassNotFoundException e) {
			System.err.println("No tienes el driver en tu build-path?");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return databaseConnection;
	}
}
