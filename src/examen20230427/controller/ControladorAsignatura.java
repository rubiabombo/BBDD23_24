package examen20230427.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen20230427.model.Asignatura;



public class ControladorAsignatura {

	/**
	 * 
	 * @return
	 */
	public static List<Asignatura> findAllByDocente(int idDocente) {
		List<Asignatura> cursos = new ArrayList<Asignatura>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from profesoresymaterias.asignatura where idDocente = " + idDocente);
			
			while (rs.next()) {
				Asignatura m = new Asignatura();
				m.setId(rs.getInt("id"));
				m.setDenominacion(rs.getString("denominacion"));
				cursos.add(m);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}
	
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Asignatura a) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update nivelesymaterias.materia set nombre = ?, idNivel = ?, codigo = ?, urlClassroom = ?, admiteMatricula = ?, fechaInicio = ? where id = ?");
		
			ps.setString(1, a.getDenominacion());
			ps.setInt(2, a.getId());
			
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar (Asignatura a) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into materia (id, nombre, idNivel, codigo, urlClassroom, admiteMatricula, fechaInicio) "
					+ " values (?, ?, ?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, a.getDenominacion());
			ps.setInt(3, a.getId());
		
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int eliminar (int id) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from asignatura where id = ?");
		
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from asignatura");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



}
