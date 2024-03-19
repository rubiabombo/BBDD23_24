package alquileres.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import alquileres.model.Inquilino;

public class ControladorInquilino {
	
//	public static int insertar (Usuario p) {
//		
//		try {
//			Connection conn = ConnectionManager.getConexion();
//			PreparedStatement ps = conn.prepareStatement(
//					"insert into usuario (id, email, usuario, password, idIdioma) "
//					+ " values (?, ?, ?, ?, ?)");
//		
//			int siguienteIdValido = getSiguientIdValido();
//			ps.setInt(1, siguienteIdValido);
//			ps.setString(2, p.getEmail());
//			ps.setString(3, p.getUsuario());
//			ps.setString(4, p.getPassword());
//			ps.setInt(5, p.getIdIdioma());
//			int rows = ps.executeUpdate();
//			ps.close();
//			conn.close();
//			return rows;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

	/**
	 * 
	 * @param m
	 * @return
	 */
	public static int modificar (Inquilino m) {
		
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update inquilino set dni = ?, nombreCompleto = ?, "
					+ "fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ?, idVivienda = ? where id = ?");
		
			ps.setString(1, m.getDni());
			ps.setString(2, m.getNombreCompleto());
			ps.setDate(3, new java.sql.Date(m.getFechaInicioAlquiler().getTime()));
			ps.setDate(4, new java.sql.Date(m.getFechaFinAlquiler().getTime()));
			ps.setFloat(5, m.getCuotaMensual());
			ps.setInt(6, m.getIdVivienda());
			ps.setInt(7, m.getId());
			
			return ps.executeUpdate();
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
					"select max(id) from usuario");
		
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
	
	/**
	 * 
	 * @param idPais
	 * @return
	 */
	public static Inquilino findAllByIdVivienda(int idVivienda) {
		Inquilino m = null;
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from inquilino where idVivienda = " + idVivienda);
			
			while (rs.next()) {
				
				m = new Inquilino();
				m.setId(rs.getInt("id"));
				m.setDni(rs.getString("dni"));
				m.setNombreCompleto(rs.getString("nombreCompleto"));
				m.setFechaInicioAlquiler(rs.getDate("fechaInicioAlquiler"));
				m.setFechaFinAlquiler(rs.getDate("fechaFinAlquiler"));
				m.setCuotaMensual(rs.getFloat("cuotaMensual"));
				m.setIdVivienda(rs.getInt("idVivienda"));
				
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return m;
	}

}

