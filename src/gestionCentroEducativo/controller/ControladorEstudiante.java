package gestionCentroEducativo.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gestionCentroEducativo.model.Estudiante;
import gestionCentroEducativo.utils.ConnectionManager;



public class ControladorEstudiante {
	
	 /**
	  * 
	  * @return
	  * @throws SQLException
	  */
		public static Estudiante firstRegister() throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select * from centroeducativo.estudiante order by id limit 1");

			Estudiante e = new Estudiante();
			while (rs.next()) {
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido1(rs.getString(3));
				e.setApellido2(rs.getString(4));
				e.setDni(rs.getString(5));
				e.setDireccion(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setTelefono(rs.getString(8));
				e.setIdTipologiaSexo(rs.getInt(9));
				e.setImagen(rs.getBytes(10));
				e.setColorPreferido(rs.getString(11));

				
			}

			conn.close();
			rs.close();
			s.close();
			return e;
		}

		/**
		 * 
		 * @throws SQLException
		 */

		public static Estudiante lastRegister() throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select * from centroeducativo.estudiante order by id desc limit 1");

			Estudiante e = new Estudiante();
			while (rs.next()) {
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido1(rs.getString(3));
				e.setApellido2(rs.getString(4));
				e.setDni(rs.getString(5));
				e.setDireccion(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setTelefono(rs.getString(8));
				e.setIdTipologiaSexo(rs.getInt(9));
				e.setImagen(rs.getBytes(10));
				e.setColorPreferido(rs.getString(11));


				
			}
			conn.close();
			rs.close();
			s.close();
			return e;
		}

		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static Estudiante nextRegister(Estudiante e) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = e.getId();

			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s
					.executeQuery("select * from centroeducativo.estudiante where id > " + idActual + " order by id limit " + 1);

			Estudiante estu = new Estudiante();
			while (rs.next()) {
				estu.setId(rs.getInt(1));
				estu.setNombre(rs.getString(2));
				estu.setApellido1(rs.getString(3));
				estu.setApellido2(rs.getString(4));
				estu.setDni(rs.getString(5));
				estu.setDireccion(rs.getString(6));
				estu.setEmail(rs.getString(7));
				estu.setTelefono(rs.getString(8));
				estu.setIdTipologiaSexo(rs.getInt(9));
				estu.setImagen(rs.getBytes(10));
				estu.setColorPreferido(rs.getString(11));


				
			}

			conn.close();
			rs.close();
			s.close();
			return estu;
		}

		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static Estudiante previousRegister(Estudiante e) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = e.getId();

			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(
					"select * from centroeducativo.estudiante where id < " + idActual + " order by id desc limit " + 1);

			Estudiante estu = new Estudiante();
			while (rs.next()) {
				estu.setId(rs.getInt(1));
				estu.setNombre(rs.getString(2));
				estu.setApellido1(rs.getString(3));
				estu.setApellido2(rs.getString(4));
				estu.setDni(rs.getString(5));
				estu.setDireccion(rs.getString(6));
				estu.setEmail(rs.getString(7));
				estu.setTelefono(rs.getString(8));
				estu.setIdTipologiaSexo(rs.getInt(9));
				estu.setImagen(rs.getBytes(10));
				estu.setColorPreferido(rs.getString(11));


				
			}
			conn.close();
			rs.close();
			s.close();
			return estu;
		}

		/**
		 * 
		 * @param curso
		 * @param fecha
		 * @return
		 * @throws SQLException
		 */

		public static int updateRegister(Estudiante e) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = e.getId();

			PreparedStatement ps = conn
					.prepareStatement("update centroeducativo.estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, "
							+ "dni = ?, direccion = ?, email = ?, telefono = ?, idSexo = ?, imagen = ?, colorPreferido = ?  where id = " + idActual);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getApellido1());
			ps.setString(3, e.getApellido2());
			ps.setString(4, e.getDni());
			ps.setString(5, e.getDireccion());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getTelefono());
			ps.setInt(8, e.getIdTipologiaSexo());
			ps.setBytes(9, e.getImagen());
			ps.setString(10, e.getColorPreferido());




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

		public static int insertRegister(Estudiante e) throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			e.setId(escogerPrimerIDDisponible());

			PreparedStatement ps = conn
					.prepareStatement("insert into centroeducativo.estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, idSexo, imagen, colorPreferido) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, e.getId());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getApellido1());
			ps.setString(4, e.getApellido2());
			ps.setString(5, e.getDni());
			ps.setString(6, e.getDireccion());
			ps.setString(7, e.getEmail());
			ps.setString(8, e.getTelefono());
			ps.setInt(9, e.getIdTipologiaSexo());
			ps.setBytes(10, e.getImagen());
			ps.setString(11, e.getColorPreferido());


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

		public static int deleteRegister(Estudiante e) throws SQLException {
			
			Connection conn = ConnectionManager.getConexion();
			int idActual = e.getId();
			PreparedStatement ps = conn.prepareStatement("Delete from centroeducativo.estudiante where id = ?");
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
			ResultSet rs = s.executeQuery("select max(id) from estudiante");

			while (rs.next()) {
				idDisponible = rs.getInt(1);

			}

			rs.close();
			s.close();
			return idDisponible + 1;

		}

}