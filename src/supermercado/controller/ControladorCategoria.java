package supermercado.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import supermercado.model.Categoria;



	public class ControladorCategoria {
		
		private static String nombreTabla = "categoria";

		
		public static List<Categoria> findAll() {
			List<Categoria> l = new ArrayList<Categoria>();
			
			try {
				ResultSet rs = ConnectionManager.getConexion().createStatement()
						.executeQuery("Select * from " + nombreTabla);
				while (rs.next()) {
					Categoria c = getEntidadFromResultSet(rs);
					l.add(c);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return l;		
		}
		
		
		
		
		
		private static Categoria getEntidadFromResultSet (ResultSet rs) throws SQLException {
			Categoria o = new Categoria();
			o.setId(rs.getInt("id"));
			o.setDescripcion(rs.getString("descripcion"));
			return o;
		}
	}
