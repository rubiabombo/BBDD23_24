package examen20230427.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen20230427.model.AsignaturaPordocente;





public class ControladorAsignaturaPordocente {
	/**
	 * 
	 * @return
	 */
	public static List<AsignaturaPordocente> findAll() {
		List<AsignaturaPordocente> cursos = new ArrayList<AsignaturaPordocente>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from asignaturapordocente");
			
			while (rs.next()) {
				AsignaturaPordocente c = new AsignaturaPordocente();
				c.setId(rs.getInt("id"));
				c.setIdAsignatura(rs.getInt("idAsignatura"));
				c.setIdDocente(rs.getInt("idDocente"));
				cursos.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}

}