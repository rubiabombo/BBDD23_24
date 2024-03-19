package nivelesymaterias.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nivelesymaterias.model.CentroEducativo;

public class ControladorCentro {

	/**
	 * 
	 * @return
	 */
	public static List<CentroEducativo> findAll() {
		List<CentroEducativo> lista = new ArrayList<CentroEducativo>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo");
			
			while (rs.next()) {
				CentroEducativo c = new CentroEducativo();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				lista.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}

}
