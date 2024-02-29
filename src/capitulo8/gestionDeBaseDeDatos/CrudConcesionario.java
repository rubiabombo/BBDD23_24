package capitulo8.gestionDeBaseDeDatos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Utils.UtilsBBDD;



public class CrudConcesionario {
	
	private static String TABLA = "concesionario";

	
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
	 * Actualizo un registro de la tabla
	 * @param conn
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	private static void realiceUpdate(Connection conn) throws HeadlessException, SQLException {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a modificar: "));
		if(Utils.UtilsBBDD.isValidId(conn, id, TABLA)) {
			PreparedStatement ps = conn.prepareStatement("update tutorialjavacoches.concesionario set cif = ? , nombre = ?, localidad = ? where id = ?");
			ps.setString(1, JOptionPane.showInputDialog("Introduzca cif del concesionario: "));
			ps.setString(2, JOptionPane.showInputDialog("Introduzca nombre del concesionario: "));
			ps.setString(3, JOptionPane.showInputDialog("Introduzca localidad del concesionario: "));
			ps.setInt(4, id);
			
			int rows = ps.executeUpdate();
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			ps.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * Añado un registro a la tabla
	 * @param conn
	 * @throws SQLException
	 */
	private static void realiceInsert(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("insert into tutorialjavacoches.concesionario (id, cif, nombre, localidad) values (?, ?, ?, ?)");
		ps.setInt(1, UtilsBBDD.getNextValidID(conn, TABLA));
		ps.setString(2, JOptionPane.showInputDialog("Introduzca cif del concesionario: "));
		ps.setString(3, JOptionPane.showInputDialog("Introduzca nombre del concesionario: "));
		ps.setString(4, JOptionPane.showInputDialog("Introduzca localidad del concesionario: "));

		int filasAfectadas = ps.executeUpdate();
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		ps.close();
	}



	/**
	 * Muestro el menú y le pido al usuario una opción
	 * @return
	 */
	private static int menu() {
		
		System.out.println("\n\nAdministracion de la tabla concesionario");
		System.out.println("----------------------------------------\n");
		System.out.println("1. Mostrar datos de la tabla");
		System.out.println("2. Añadir un dato a la tabla");
		System.out.println("3. Modificar un dato de la tabla");
		System.out.println("4. Eliminar un registro de la tabla");
		System.out.println("Pulse cualquier otro número para volver");
		return Utils.Utils.obtenerEnteroPorJoptionPane("Elija opción: ");
		
		
	}

}
