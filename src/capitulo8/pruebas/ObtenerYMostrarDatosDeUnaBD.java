package capitulo8.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObtenerYMostrarDatosDeUnaBD {

	public static void main(String[] args) {
		String driver = BDLeerFichero.getProperty("JDBC_DRIVER_CLASS");
		String user = BDLeerFichero.getProperty("JDBC_USER");
		String password = BDLeerFichero.getProperty("JDBC_PASSWORD");
		String host = BDLeerFichero.getProperty("JDBC_HOST");
		String schema = BDLeerFichero.getProperty("JDBC_SCHEMA_NAME");
		String properties = BDLeerFichero.getProperty("JDBC_PROPERTIES");
		
		
		try {
			// A través de la siguiente línea comprobamos si tenemos acceso al driver MySQL, si no fuera así
			// no podemos trabajar con esa BBDD.
			Class.forName(driver);
		   
			// Necesitamos obtener un acceso a la BBDD, eso se materializa en un objeto de tipo Connection, al cual
			// le tenemos que pasar los parámetros de conexión.
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);
		   
			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo Statement
			Statement s = (Statement) conexion.createStatement(); 
			
			// La ejecución de la consulta se realiza a través del objeto Statement y se recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros obtenidos por la consulta
			ResultSet rs = s.executeQuery ("select * from concesionario");
		   
			// Navegaci�n del objeto ResultSet
			while (rs.next()) { 
				System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString(3)+ " " + rs.getString(4)); 
			}
			
			// Cierre de los elementos
			rs.close();
			s.close();
			conexion.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
		}
	}


}
