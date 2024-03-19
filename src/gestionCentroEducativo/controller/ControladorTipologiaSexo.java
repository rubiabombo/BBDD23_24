package gestionCentroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestionCentroEducativo.model.TipologiaSexo;
import gestionCentroEducativo.utils.ConnectionManager;



public class ControladorTipologiaSexo {
	
	public static List<TipologiaSexo> allRegisters() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from centroeducativo.tipologiaSexo");

		List<TipologiaSexo> sexo = new ArrayList<TipologiaSexo>();

		while (rs.next()) {
			TipologiaSexo sex = new TipologiaSexo();
			sex.setId(rs.getInt(1));
			sex.setDescripcion(rs.getString(2));
			sexo.add(sex);
		}

		conn.close();
		rs.close();
		s.close();
		return sexo;
	}

}
