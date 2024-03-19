package nivelesymaterias.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nivelesymaterias.model.Nivel;

public class ControladorNivel {


	public static List<Nivel> findAllByIdCentro(int idCentro) {
		List<Nivel> lista = new ArrayList<Nivel>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel where idCentro = " + idCentro);
			
			while (rs.next()) {
				Nivel c = new Nivel();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setIdCentro(rs.getInt("idCentro"));
				lista.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}


}

