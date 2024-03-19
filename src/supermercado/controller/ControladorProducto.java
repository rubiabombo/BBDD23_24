package supermercado.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import supermercado.model.Producto;

public class ControladorProducto {

	private static String nombreTabla = "producto";

	
	/**
	 * 
	 * @param idCategoria
	 * @return
	 */
	public static List<Producto> findAllByIdCategoria(int idCategoria) {
		List<Producto> l = new ArrayList<Producto>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla +
							" where idCategoria = " + idCategoria);
			while (rs.next()) {
				Producto c = getEntidadFromResultSet(rs);
				l.add(c);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private static Producto getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Producto o = new Producto();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));
		o.setCodigo(rs.getString("codigo"));
		o.setIdCategoria(rs.getInt("idCategoria"));
		o.setPerecedero(rs.getBoolean("perecedero"));
		o.setFechaCaducidad(rs.getDate("fechaCaducidad"));
		o.setUnidadesStock(rs.getInt("unidadesStock"));
		
		return o;
	}
	
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static int save(Producto p) {
		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement(
					"update " + nombreTabla + " set descripcion = ?, codigo = ?, "
							+ "idCategoria = ?, perecedero = ?, fechaCaducidad = ?, "
							+ "unidadesStock = ? where id = ?");
			
			ps.setString(1, p.getDescripcion());
			ps.setString(2, p.getCodigo());
			ps.setInt(3, p.getIdCategoria());
			ps.setBoolean(4, p.isPerecedero());
			if (p.getFechaCaducidad() != null) {
				ps.setDate(5,  new java.sql.Date(p.getFechaCaducidad().getTime()));
			}
			else {
				ps.setDate(5, null);
			}
			ps.setInt(6, p.getUnidadesStock());
			ps.setInt(7, p.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}
}







