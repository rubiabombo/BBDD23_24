package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import capitulo8.pruebas.BDLeerFichero;

public class UtilsBBDD {
	
	public static int getNextValidID(Connection conn, String tabla) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from " + tabla);
		ResultSet rs = ps.executeQuery ();
		
		if(rs.next()) return rs.getInt(1)+1;
		
		return 1;
	}
	
	public static boolean isValidId(Connection conn, int id, String tabla) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select id from tutorialjavacoches." + tabla);
		ResultSet rs = ps.executeQuery ();
		   
		// Navegaci�n del objeto ResultSet
		while (rs.next()) { 
			if(id == rs.getInt(1)) return true; 
		}
		
		return false;
	}
	
	public static void realizarDelete(Connection conn, String tabla) throws SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a borrar: "));
		if(isValidId(conn, id, tabla)) {
			PreparedStatement ps = conn.prepareStatement("delete from tutorialjavacoches." +tabla+ " where id = " + id);
			int rows = ps.executeUpdate();
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			ps.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}
	
	public static void realizarSelect(Connection conn,String tabla) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select * from tutorialjavacoches." + tabla);
		ResultSet rs = ps.executeQuery ();
		
		System.out.println("\n\n");
		// Navegaci�n del objeto ResultSet
		while (rs.next()) { 
			if(tabla=="fabricante") System.out.println (rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
			else if(tabla=="concesionario") System.out.println (rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getString(4));
			else if(tabla=="cliente") System.out.println (rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getDate(6)+ " " + rs.getBoolean(7));
			else if(tabla=="coche") System.out.println (rs.getInt(1) + " " + rs.getInt(2)+ " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
			else if(tabla=="venta") System.out.println (rs.getInt(1) + " " + rs.getInt(2)+ " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getDate(5) + " " + rs.getFloat(6));
		}
		System.out.println("\n\n");
		// Cierre de los elementos
		rs.close();
		ps.close();
		
	}
	
	public static Connection obtenerConeccion() throws ClassNotFoundException, SQLException {
		
		String driver = BDLeerFichero.getProperty("JDBC_DRIVER_CLASS");
		String user = BDLeerFichero.getProperty("JDBC_USER");
		String password = BDLeerFichero.getProperty("JDBC_PASSWORD");
		String host = BDLeerFichero.getProperty("JDBC_HOST");
		String schema = BDLeerFichero.getProperty("JDBC_SCHEMA_NAME");
		String properties = BDLeerFichero.getProperty("JDBC_PROPERTIES");
		
		
		Class.forName(driver);
	    Connection conn = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);
		
	    return conn;
	}

}
