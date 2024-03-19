package gestionCentroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gestionCentroEducativo.model.Materia;
import gestionCentroEducativo.utils.ConnectionManager;



public class ControladorMateria {

	public static Materia firstRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.materia order by id limit 1");

		Materia materia = new Materia();
		while (rs.next()) {
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setAcronimo(rs.getString(3));
			materia.setCursoId(rs.getInt(4));
		}

		conn.close();
		rs.close();
		s.close();
		return materia;
	}

	public static Materia lastRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.materia order by id desc limit 1");

		Materia materia = new Materia();
		while (rs.next()) {
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setAcronimo(rs.getString(3));
			materia.setCursoId(rs.getInt(4));
		}

		conn.close();
		rs.close();
		s.close();
		return materia;
	}

	public static Materia nextRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = m.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery(
				"select * from centroeducativo.materia where id > " + idActual + " order by id limit " + 1);

		Materia materia = new Materia();
		while (rs.next()) {
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setAcronimo(rs.getString(3));
			materia.setCursoId(rs.getInt(4));
		}

		conn.close();
		rs.close();
		s.close();
		return materia;
	}

	public static Materia previousRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = m.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery(
				"select * from centroeducativo.materia where id < " + idActual + " order by id desc limit " + 1);

		Materia materia = new Materia();
		while (rs.next()) {
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setAcronimo(rs.getString(3));
			materia.setCursoId(rs.getInt(4));
		}

		conn.close();
		rs.close();
		s.close();
		return materia;
	}

	public static int updateRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = m.getId();

		PreparedStatement ps = conn
				.prepareStatement("update centroeducativo.materia set nombre = ?, acronimo = ?, curso_Id = ? where id = " + idActual);
		ps.setString(1, m.getNombre());
		ps.setString(2, m.getAcronimo());
		ps.setInt(3, m.getCursoId());

		int filasAlteradas = ps.executeUpdate();

		conn.close();
		ps.close();
		return filasAlteradas;
	}

	public static int insertRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		m.setId(escogerPrimerIDDisponible());

		PreparedStatement ps = conn
				.prepareStatement("insert into centroeducativo.materia (id, nombre, acronimo, curso_id) values (?, ?, ?, ?)");

		ps.setInt(1, m.getId());
		ps.setString(2, m.getNombre());
		ps.setString(3, m.getAcronimo());
		ps.setInt(4, m.getCursoId());

		int filasAlteradas = ps.executeUpdate();

		ps.close();
		conn.close();

		return filasAlteradas;

	}

	public static int deleteRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		int idActual = m.getId();
		PreparedStatement ps = conn.prepareStatement("Delete from centroeducativo.materia where id = ?");
		ps.setInt(1, idActual);
		int filasAlteradas = ps.executeUpdate();
		ps.close();
		conn.close();
		return filasAlteradas;

	}

	public static int escogerPrimerIDDisponible() throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idDisponible = 0;
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) from materia");

		while (rs.next()) {
			idDisponible = rs.getInt(1);

		}

		rs.close();
		s.close();
		return idDisponible + 1;

	}

}
