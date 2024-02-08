package capitulo8.gestionDeBaseDeDatos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import Utils.UtilsBBDD;

public class ControladorCliente {
	
	private static String TABLA = "cliente";
	
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
			PreparedStatement ps = conn.prepareStatement("update tutorialjavacoches.cliente set nombre = ? , apellidos = ? , localidad = ? , dniNie = ? , fecha nacimiento = ?, activo= ? where id = ?");
			ps.setString(1, JOptionPane.showInputDialog("Introduzca nombre del cliente: "));
			ps.setString(2, JOptionPane.showInputDialog("Introduzca apellidos del cliente: "));
			ps.setString(3, JOptionPane.showInputDialog("Introduzca localidad del cliente: "));
			ps.setString(4, JOptionPane.showInputDialog("Introduzca dniNie del cliente: "));
			ps.setDate(5, (java.sql.Date) introduceDate());
			int act = JOptionPane.showConfirmDialog(null, "¿Está activo el cliente?");
			if(act == 0) ps.setBoolean(6, true);
			else if(act == 1) ps.setBoolean(6, false);
			else {
				ps.close();
				return;
			}
			
			
			ps.setInt(7, UtilsBBDD.getNextValidID(conn, TABLA));
			
			int rows = ps.executeUpdate();
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			ps.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * Le pido al usuario una fecha y la convierto en el Date correspondiente
	 * @return
	 */
	private static java.sql.Date introduceDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = JOptionPane.showInputDialog("Introduzca fecha de nacimiento dd/MM/yyyy: ");
		Date  date = null;
		java.sql.Date date2 = null;     
	    try {
	    	date = sdf.parse(fecha);
	    } catch (ParseException e) {
    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    
	    date2.setTime(date.getTime()); 
		return date2;
	}



	/**
	 * Añado un registro a la tabla
	 * @param conn
	 * @throws SQLException
	 */
	private static void realiceInsert(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("insert into tutorialjavacoches.cliente (id, nombre , apellidos, localidad, dniNie FechaNac, activo) values (?, ?, ?, ?, ?, ?, true)");
		ps.setInt(1, UtilsBBDD.getNextValidID(conn, TABLA));
		ps.setString(2, JOptionPane.showInputDialog("Introduzca nombre del cliente: "));
		ps.setString(3, JOptionPane.showInputDialog("Introduzca apellidos del cliente: "));
		ps.setString(4, JOptionPane.showInputDialog("Introduzca localidad del cliente: "));
		ps.setString(5, JOptionPane.showInputDialog("Introduzca dniNie del cliente: "));
		ps.setDate(6, introduceDate());
		

		int filasAfectadas = ps.executeUpdate();
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		ps.close();
	}



	/**
	 * Imprimo el menu y pido al usuario una opcion del menu
	 * @return
	 */
	private static int menu() {
		
		System.out.println("\n\nAdministracion de la tabla cliente");
		System.out.println("---------------------------------- \n");
		System.out.println("1. Mostrar datos de la tabla");
		System.out.println("2. Añadir un dato a la tabla");
		System.out.println("3. Modificar un dato de la tabla");
		System.out.println("4. Eliminar un registro de la tabla");
		System.out.println("Pulse cualquier otro número para volver");
		return Utils.Utils.obtenerEnteroPorJoptionPane("Elija opción: ");
		
		
	}

}
