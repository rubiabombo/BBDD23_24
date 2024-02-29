package capitulo9.gestionFabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionFabricante extends SupertipoGestion {
	public static Fabricante getPrimero(Connection conn) throws SQLException {
		return getFabricante (conn,
				"select * from tutorialjavacoches.fabricante "
				+ "order by id asc limit 1");
	}

	
	
	public static Fabricante getUltimo(Connection conn) throws SQLException {
		return getFabricante(conn, 
				"select * from tutorialjavacoches.fabricante "
				+ "order by id desc limit 1");
	}

	
	public static Fabricante getAnterior(Connection conn, int idActual) throws SQLException {
		String sql = "select * from tutorialjavacoches.fabricante where id < " + idActual
				+ " order by id desc limit 1";
//		System.out.println("sql: " + sql);
		return getFabricante (conn, sql);
	}

	
	public static Fabricante getSiguiente(Connection conn, int idActual) throws SQLException {
		return getFabricante (conn,
				"select * from tutorialjavacoches.fabricante where id > " + idActual
				+ " order by id asc limit 1");
	}

	
	private static Fabricante getFabricante(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Fabricante f = null;
		if (rs.next()) {
			f = new Fabricante();
			f.setId(rs.getInt("id"));
			f.setCif(rs.getString("cif"));
			f.setNombre(rs.getString("nombre"));
		}
		return f;
	}
	
	
	/**
	 * 
	 */
	public static int insercion (Fabricante f, Connection conn) {
		try {
			int nuevoId = nextIdEnTabla("fabricante");
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into fabricante (id, cif, nombre) "
					+ "values (?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, f.getCif());
			ps.setString(3, f.getNombre());
			
			ps.executeUpdate();
			return nuevoId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	/**
	 * 
	 */
	public static void modificacion (Fabricante f, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "update fabricante set cif = ?, nombre = ? "
					+ "where id = ?");
			ps.setString(1, f.getCif());
			ps.setString(2, f.getNombre());
			ps.setInt(3, f.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 */
	public static void eliminacion (int id, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete fabricante where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
