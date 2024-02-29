package capitulo8.gestionFabricante;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import capitulo8.pruebas.BDLeerFichero;

public class Fabricante {
	public static void main(String[] args) {
		
		try {
			
			Connection conn = obtenerConeccion();
			do {
				switch (menu()) {
					case 0: {
						conn.close();
						System.out.println("\n\n Hasta luego  ;-)");
						System.exit(0);
						break;
					}
				
					case 1: {
						realizarSelect(conn);
						break;
					}
					case 2: {
						realizarInsert(conn);
						break;
					}
					case 3: {
						realizarUpdate(conn);
						break;
					}
					case 4: {
						realizarDelete(conn);
						break;
					}
				
				}
				
			}while(true);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void realizarDelete(Connection conn) throws SQLException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a borrar: "));
		if(isValidId(conn, id)) {
			Statement s = (Statement) conn.createStatement();
			int rows = s.executeUpdate("delete from tutorialjavacoches.fabricante where id = " + id);
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			s.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	private static boolean isValidId(Connection conn, int id) throws SQLException {
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery ("select id from tutorialjavacoches.fabricante");
		   
		// Navegaci�n del objeto ResultSet
		while (rs.next()) { 
			if(id == rs.getInt(1)) return true; 
		}
		
		return false;
	}

	/**
	 * 
	 * @param conn
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	private static void realizarUpdate(Connection conn) throws HeadlessException, SQLException {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a modificar: "));
		if(isValidId(conn, id)) {
			Statement s = (Statement) conn.createStatement();
			String cif = JOptionPane.showInputDialog("Introduzca cif del fabricante: ");
			String nombre = JOptionPane.showInputDialog("Introduzca nombre del fabricante: ");
			
			int rows = s.executeUpdate("update tutorialjavacoches.fabricante set cif = '"+ cif + "', nombre = '" + nombre + "' where id = " + id);
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			s.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void realizarInsert(Connection conn) throws SQLException {
		
		Statement s = (Statement) conn.createStatement();
		
		String cif = JOptionPane.showInputDialog("Introduzca cif del fabricante: ");
		String nombre = JOptionPane.showInputDialog("Introduzca nombre del fabricante: ");
		
		int rows = s.executeUpdate("insert into tutorialjavacoches.fabricante values (" + getNextValidID(conn) +", '" + cif + "', '" + nombre + "');");
		
		System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
		s.close();
	}


	

	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private static int getNextValidID(Connection conn) throws SQLException {
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery ("select max(id) from tutorialjavacoches.fabricante");
		
		if(rs.next()) return rs.getInt(1)+1;
		
		return 1;
	}

	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void realizarSelect(Connection conn) throws SQLException {
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery ("select * from tutorialjavacoches.fabricante");
		
		System.out.println("\n\n");
		// Navegaci�n del objeto ResultSet
		while (rs.next()) { 
			System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getString(3)); 
		}
		System.out.println("\n\n");
		// Cierre de los elementos
		rs.close();
		s.close();
		
	}


	/**
	 * 
	 * @return
	 */
	private static int menu() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Administracion de la tabla fabricante");
		System.out.println("------------------------------------- \n");
		System.out.println("1. Mostrar datos de la tabla");
		System.out.println("2. Añadir un dato a la tabla");
		System.out.println("3. Modificar un dato de la tabla");
		System.out.println("4. Eliminar un registro de la tabla");
		System.out.println("0. Salir \n");
		System.out.print("Elija opción: ");
		return sc.nextInt();
		
		
	}

	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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