package alquileres.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import alquileres.model.Vivienda;

public class ControladorVivienda {

	/**
	 * 
	 * @param idPais
	 * @return
	 */
	public static List<Vivienda> findAllByIdLocalidad(int idLocalidad) {
		List<Vivienda> lista = new ArrayList<Vivienda>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from vivienda where idLocalidad = " + idLocalidad);
			
			while (rs.next()) {
				Vivienda m = new Vivienda();
				m.setId(rs.getInt("id"));
				m.setDescripcion(rs.getString("descripcion"));
				m.setIdLocalidad(rs.getInt("idLocalidad"));
				lista.add(m);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}
	
}
