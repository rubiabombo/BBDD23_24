package capitulo8.gestionDeBaseDeDatos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Utils.UtilsBBDD;

public class CrudVenta {

	private static String TABLA = "venta";

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
	 * 
	 * @param conn
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	private static void realiceUpdate(Connection conn) throws HeadlessException, SQLException {
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Seleccione id del registro a modificar: "));
		if(Utils.UtilsBBDD.isValidId(conn, id, TABLA)) {
			PreparedStatement ps = conn.prepareStatement("update tutorialjavacoches.venta set idCliente = ? , idConcesionario = ? , idCoche = ? , fecha = ? , precioVenta = ? where id = ?");
			ps.setInt(6, UtilsBBDD.getNextValidID(conn, TABLA));
			showDatas(conn, "cliente");
			ps.setString(1, JOptionPane.showInputDialog("Introduzca id del cliente: "));
			showDatas(conn, "concesionario");
			ps.setString(2, JOptionPane.showInputDialog("Introduzca id del concesionario: "));
			showDatas(conn, "coche");
			ps.setString(3, JOptionPane.showInputDialog("Introduzca id del coche: "));
			ps.setDate(4, introduceDate());
			ps.setFloat(5,Float.parseFloat(JOptionPane.showInputDialog("Introduzca precio de la venta: ")));
			
			int rows = ps.executeUpdate();
			System.out.println("\n\nFilas Afectadas: " + rows + "\n\n");
			ps.close();
		}
		else JOptionPane.showMessageDialog(null, "El id dado no se encuentra registrado en la base de datos");
		
	}

	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void realiceInsert(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("insert into tutorialjavacoches.venta (id, idCliente, idConcesionario, idCoche, fecha, precioVenta) values (?, ?, ?, ?, ?, ?)");
		ps.setInt(1, UtilsBBDD.getNextValidID(conn, TABLA));
		showDatas(conn, "cliente");
		ps.setString(2, JOptionPane.showInputDialog("Introduzca id del cliente: "));
		showDatas(conn, "concesionario");
		ps.setString(3, JOptionPane.showInputDialog("Introduzca id del concesionario: "));
		showDatas(conn, "coche");
		ps.setString(4, JOptionPane.showInputDialog("Introduzca id del coche: "));
		ps.setDate(5, introduceDate());
		ps.setFloat(6,Float.parseFloat(JOptionPane.showInputDialog("Introduzca precio de la venta: ")));
		
		

		int filasAfectadas = ps.executeUpdate();
	   
		System.out.println("Filas afectadas: " + filasAfectadas);
		
		ps.close();
	}
	
	/**
	 * 
	 * @return
	 */
	private static java.sql.Date introduceDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = JOptionPane.showInputDialog("Introduzca fecha de venta dd/MM/yyyy: ");
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
	 * 
	 * @return
	 */
	private static int menu() {
		
		System.out.println("\n\nAdministracion de la tabla venta");
		System.out.println("--------------------------------\n");
		System.out.println("1. Mostrar datos de la tabla");
		System.out.println("2. Añadir un dato a la tabla");
		System.out.println("3. Modificar un dato de la tabla");
		System.out.println("4. Eliminar un registro de la tabla");
		System.out.println("Pulse cualquier otro número para volver");
		return Utils.Utils.obtenerEnteroPorJoptionPane("Elija opción: ");
		
		
	}
	
	/***
	 * 
	 * @param conn
	 * @param table
	 * @throws SQLException
	 */
	private static void showDatas(Connection conn, String table) throws SQLException {
		PreparedStatement ps;
		if(table != "coche")  ps = conn.prepareStatement("select id, nombre from tutorialjavacoches."+ table);
		else  ps = conn.prepareStatement("select id, modelo from tutorialjavacoches."+ table);
		
		ResultSet rs = ps.executeQuery ();
		String text = "";
		System.out.println("\n\n");
		// Navegaci�n del objeto ResultSet
		while (rs.next()) {
			if(table != "coche") System.out.println (rs.getInt("id") + " " + rs.getString("nombre"));
			else System.out.println (rs.getInt("id") + " " + rs.getString("modelo"));

		}
		
	}
		
		


}



