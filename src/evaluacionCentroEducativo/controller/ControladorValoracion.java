package evaluacionCentroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import evaluacionCentroEducativo.model.Estudiante;
import evaluacionCentroEducativo.model.Materia;
import evaluacionCentroEducativo.model.Profesor;
import evaluacionCentroEducativo.model.ValoracionMateria;

import evaluacionCentroEducativo.model.Curso;

import evaluacionCentroEducativo.controller.ConnectionManager;

public class ControladorValoracion {


	public static ValoracionMateria firstRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.valoracionmateria order by id limit 1");

		ValoracionMateria vm = new ValoracionMateria();
		if (rs.next()) {
			vm.setId(rs.getInt(1));
			vm.setIdProfesor(rs.getInt(2));
			vm.setIdEstudiante(rs.getInt(3));
			vm.setIdMateria(rs.getInt(4));
			vm.setValoracion(rs.getFloat(5));
		}

		conn.close();
		rs.close();
		s.close();
		return vm;
	}

	public static ValoracionMateria lastRegister() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.valoracionmateria order by id desc limit 1");

		ValoracionMateria vm = new ValoracionMateria();
		if (rs.next()) {
			vm.setId(rs.getInt(1));
			vm.setIdProfesor(rs.getInt(2));
			vm.setIdEstudiante(rs.getInt(3));
			vm.setIdMateria(rs.getInt(4));
			vm.setValoracion(rs.getFloat(5));
		}

		conn.close();
		rs.close();
		s.close();
		return vm;
	}

	public static ValoracionMateria previousRegister(ValoracionMateria valm) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = valm.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.valoracionmateria where id < " + idActual
				+ " order by id desc limit " + 1);

		ValoracionMateria vm = new ValoracionMateria();
		while (rs.next()) {
			vm.setId(rs.getInt(1));
			vm.setIdProfesor(rs.getInt(2));
			vm.setIdEstudiante(rs.getInt(3));
			vm.setIdMateria(rs.getInt(4));
			vm.setValoracion(rs.getFloat(5));

		}
		conn.close();
		rs.close();
		s.close();
		return vm;
	}

	public static ValoracionMateria nextRegister(ValoracionMateria valm) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = valm.getId();

		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery(
				"select * from centroeducativo.valoracionmateria where id > " + idActual + " order by id limit " + 1);

		ValoracionMateria vm = new ValoracionMateria();
		while (rs.next()) {
			vm.setId(rs.getInt(1));
			vm.setIdProfesor(rs.getInt(2));
			vm.setIdEstudiante(rs.getInt(3));
			vm.setIdMateria(rs.getInt(4));
			vm.setValoracion(rs.getFloat(5));

		}
		conn.close();
		rs.close();
		s.close();
		return vm;
	}

	public static int updateRegister(ValoracionMateria vm) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = vm.getId();

		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id = "
						+ idActual);
		ps.setInt(1, vm.getIdProfesor());
		ps.setInt(2, vm.getIdEstudiante());
		ps.setInt(3, vm.getIdMateria());
		ps.setFloat(4, vm.getValoracion());

		int filasAlteradas = ps.executeUpdate();

		conn.close();
		ps.close();
		return filasAlteradas;
	}
	
	public static int insertRegister(ValoracionMateria vm) throws SQLException {

		Connection conn = ConnectionManager.getConexion();


		PreparedStatement ps = conn.prepareStatement(
				"insert into centroeducativo.valoracionmateria (id, idProfesor, idEstudiante, idMateria, valoracion) values (?, ?, ?, ?, ?)");
		ps.setInt(1, escogerPrimerIDDisponible());
		ps.setInt(2, vm.getIdProfesor());
		ps.setInt(3, vm.getIdEstudiante());
		ps.setInt(4, vm.getIdMateria());
		ps.setFloat(5, vm.getValoracion());
		

		int filasAlteradas = ps.executeUpdate();

		conn.close();
		ps.close();
		return filasAlteradas;
	}
	
	public static int deleteRegister(ValoracionMateria vm) throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		int idActual = vm.getId();
		PreparedStatement ps = conn.prepareStatement("Delete from centroeducativo.valoracionmateria where id = ?");
		ps.setInt(1, idActual);
		int filasAlteradas = ps.executeUpdate();
		ps.close();
		conn.close();
		return filasAlteradas;

	}

	public static List<Profesor> allRegistersProfesor() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.profesor");

		List<Profesor> profesorLista = new ArrayList<Profesor>();

		while (rs.next()) {
			Profesor profesor = new Profesor();
			profesor.setId(rs.getInt(1));
			profesor.setNombre(rs.getString(2));
			profesorLista.add(profesor);
		}

		conn.close();
		rs.close();
		s.close();
		return profesorLista;
	}

	public static List<Estudiante> allRegistersEstudiante() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.estudiante");

		List<Estudiante> estudianteLista = new ArrayList<Estudiante>();

		while (rs.next()) {
			Estudiante estudiante = new Estudiante();
			estudiante.setId(rs.getInt(1));
			estudiante.setNombre(rs.getString(2));
			estudianteLista.add(estudiante);
		}

		conn.close();
		rs.close();
		s.close();
		return estudianteLista;
	}

	public static List<Materia> allRegistersMateria() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.materia");

		List<Materia> estudianteMateria = new ArrayList<Materia>();

		while (rs.next()) {
			Materia materia = new Materia();
			materia.setId(rs.getInt(1));
			materia.setNombre(rs.getString(2));
			materia.setCursoId(rs.getInt(4));
			estudianteMateria.add(materia);
		}

		conn.close();
		rs.close();
		s.close();
		return estudianteMateria;
	}

	public static int escogerPrimerIDDisponible() throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idDisponible = 0;
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select max(id) from valoracionmateria");

		while (rs.next()) {
			idDisponible = rs.getInt(1);

		}

		rs.close();
		s.close();
		return idDisponible + 1;

	}

}

