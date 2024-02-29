package capitulo8.gestionDeBaseDeDatos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Utils.UtilsBBDD;

public class CrudCoche {

	private static String TABLA = "coche";

	public static void main(Connection conn) {
		
		try {
			do {
				switch (menu()) {
					case 1: {
						Utils.UtilsBBDD.realizarSelect(conn, TABLA);
						break;
					}
					case 2: {
						realiceInsert(conn);
						break;
					}
					case 3: {
						realiceUpdate(conn);
						break;
					}
					case 4: {
						Utils.UtilsBBDD.realizarDelete(conn, TABLA);
						break;
					}
					default: {
						return;
					}
				
				}
			}while(true);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	


	/**
	 * Actualizo algun registro de la tabla coche
	 * @param conn
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	private static void realiceUpdate(Connection conn) throws HeadlessException, SQLException {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a modificar: "));
		if(Utils.UtilsBBDD.isValidId(conn, id, TABLA)) {
			PreparedStatement ps = conn.prepareStatement("update tutorialjavacoches.coche set idfabricante = ? , bastidor = ?, modelo = ?, color = ? where id = ?");
			ps.setInt(5, id);
			ps.setString(1, Utils.Utils.obtenerDatoObligatorioPorJoptionPane(showTableFabricante(conn) + "\nIntroduzca id del fabricante del coche: "));
			ps.setString(2, JOptionPane.showInputDialog("Introduzca bastidor del coche: "));
			ps.setString(3, JOptionPane.showInputDialog("Introduzca modelo del coche: "));
			ps.setString(4, JOptionPane.showInputDialog("Introduzca color del coche: "));
			
			int rows = ps.executeUpdate();
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			ps.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * Añado un registro a la tabla coche
	 * @param conn
	 * @throws SQLException
	 */
	private static void realiceInsert(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("insert into tutorialjavacoches.coche (id, idfabricante, bastidor, modelo, color) values (?, ?, ?, ?, ?)");
		ps.setInt(1, UtilsBBDD.getNextValidID(conn, TABLA));
		ps.setString(2, Utils.Utils.obtenerDatoObligatorioPorJoptionPane(showTableFabricante(conn) + "\nIntroduzca id del fabricante del coche: "));
		ps.setString(3, JOptionPane.showInputDialog("Introduzca bastidor del coche: "));
		ps.setString(4, JOptionPane.showInputDialog("Introduzca modelo del coche: "));
		ps.setString(5, JOptionPane.showInputDialog("Introduzca color del coche: "));
		
		int filasAfectadas = ps.executeUpdate();
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		ps.close();
	}



	/**
	 * Muestro el menú y le pido la opcion al usuario
	 * @return
	 */
	private static int menu() {
		
		System.out.println("\n\nAdministracion de la tabla coche");
		System.out.println("--------------------------------\n");
		System.out.println("1. Mostrar datos de la tabla");
		System.out.println("2. Añadir un dato a la tabla");
		System.out.println("3. Modificar un dato de la tabla");
		System.out.println("4. Eliminar un registro de la tabla");
		System.out.println("Pulse cualquier otro número para volver");
		return Utils.Utils.obtenerEnteroPorJoptionPane("Elija opción: ");
		
		
	}
	
	/**
	 * Consigo una cadena de texto con los id y los nombres de fabricate
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private static String showTableFabricante(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select id, nombre from tutorialjavacoches.fabricante");
		ResultSet rs = ps.executeQuery ();
		String text = "";
		System.out.println("\n\n");
		// Navegaci�n del objeto ResultSet
		while (rs.next()) { 
			text += rs.getInt(1) + " " + rs.getString(2) + "\n";
			
		}
		return text;
		
	}
}



