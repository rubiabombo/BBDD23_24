package examen20230427.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen20230427.model.Docente;



public class ControladorDocente {

	/**
	 * 
	 * @return
	 */
	public static List<Docente> findAllByCentro(int idAsignatura) {
		List<Docente> cursos = new ArrayList<Docente>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel where idAsignatura = " + idAsignatura);
			
			while (rs.next()) {
				Docente d = new Docente();
				d.setId(rs.getInt("id"));
				d.setNombre(rs.getString("nombre"));
				cursos.add(d);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}

}


