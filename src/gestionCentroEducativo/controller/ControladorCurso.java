package gestionCentroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestionCentroEducativo.model.Curso;
import gestionCentroEducativo.model.Materia;
import gestionCentroEducativo.utils.ConnectionManager;



public class ControladorCurso {

	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static Curso firstRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.curso order by id limit 1");

		Curso curso = new Curso();
		while (rs.next()) {
			curso.setId(rs.getInt(1));
			curso.setDescripcion(rs.getString(2));
		}

		conn.close();
		rs.close();
		s.close();
		return curso;
	}

	public static List<Curso> allRegisters() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.curso");

		List<Curso> cursos = new ArrayList<Curso>();

		while (rs.next()) {
			Curso curso = new Curso();
			curso.setId(rs.getInt(1));
			curso.setDescripcion(rs.getString(2));
			cursos.add(curso);
		}

		conn.close();
		rs.close();
		s.close();
		return cursos;
	}
	
	public static List<Curso> allRegistersFromACurse(Materia m) throws SQLException {
		
		int idMateria = m.getCursoId();

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select c.id, c.descripcion from curso c JOIN materia m using (id) where c.id = " + idMateria);

		List<Curso> cursos = new ArrayList<Curso>();

		while (rs.next()) {
			Curso curso = new Curso();
			curso.setId(rs.getInt(1));
			curso.setDescripcion(rs.getString(2));
			cursos.add(curso);
		}

		conn.close();
		rs.close();
		s.close();
		return cursos;
	}

	/**
	 * 
	 * @throws SQLException
	 */

	public static Curso lastRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.curso order by id desc limit 1");

		Curso curso = new Curso();

		while (rs.next()) {
			curso.setId(rs.getInt(1));
			curso.setDescripcion(rs.getString(2));
		}
		conn.close();
		rs.close();
		s.close();
		return curso;
	}

	/**
	 * 
	 * @param curso
	 * @return
	 * @throws SQLException
	 */

	public static Curso nextRegister(Curso curso) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = curso.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s
				.executeQuery("select * from centroeducativo.curso where id > " + idActual + " order by id limit " + 1);

		Curso c = new Curso();
		while (rs.next()) {
			c.setId(rs.getInt(1));
			c.setDescripcion(rs.getString(2));
		}

		conn.close();
		rs.close();
		s.close();
		return c;
	}

	/**
	 * 
	 * @param curso
	 * @return
	 * @throws SQLException
	 */

	public static Curso previousRegister(Curso curso) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = curso.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery(
				"select * from centroeducativo.curso where id < " + idActual + " order by id desc limit " + 1);

		Curso c = new Curso();
		while (rs.next()) {
			c.setId(rs.getInt(1));
			c.setDescripcion(rs.getString(2));

		}
		conn.close();
		rs.close();
		s.close();
		return c;
	}

	/**
	 * 
	 * @param curso
	 * @param fecha
	 * @return
	 * @throws SQLException
	 */

	public static int updateRegister(Curso curso) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = curso.getId();

		PreparedStatement ps = conn
				.prepareStatement("update centroeducativo.curso set descripcion = ? where id = " + idActual);
		ps.setString(1, curso.getDescripcion());

		int filasAlteradas = ps.executeUpdate();

		conn.close();
		ps.close();
		return filasAlteradas;
	}

	/**
	 * 
	 * @param curso
	 * @return
	 * @throws SQLException
	 */

	public static int insertRegister(Curso curso) throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		curso.setId(escogerPrimerIDDisponible());

		PreparedStatement ps = conn
				.prepareStatement("insert into centroeducativo.curso (id, descripcion) values (?, ?)");

		ps.setInt(1, curso.getId());
		ps.setString(2, curso.getDescripcion());

		int filasAlteradas = ps.executeUpdate();

		ps.close();
		conn.close();

		return filasAlteradas;

	}

	/**
	 * 
	 * @param curso
	 * @return
	 * @throws SQLException
	 */

	public static int deleteRegister(Curso curso) throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		int idActual = curso.getId();
		PreparedStatement ps = conn.prepareStatement("Delete from centroeducativo.curso where id = ?");
		ps.setInt(1, idActual);
		int filasAlteradas = ps.executeUpdate();
		ps.close();
		conn.close();
		return filasAlteradas;

	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static int escogerPrimerIDDisponible() throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idDisponible = 0;
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) from curso");

		while (rs.next()) {
			idDisponible = rs.getInt(1);

		}

		rs.close();
		s.close();
		return idDisponible + 1;

	}

}
