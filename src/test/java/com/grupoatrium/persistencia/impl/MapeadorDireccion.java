/**
 * @author ilr00819
 */
package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.grupoatrium.modelo.Direccion;

/**
 * @author ilr00819
 
 */
public class MapeadorDireccion implements RowMapper<Direccion>{
	
	
	

	public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Direccion direcc= new Direccion();
		direcc.setCalle(rs.getString("calle"));
		direcc.setNumero(rs.getInt("numero"));
		direcc.setPoblacion(rs.getString("poblacion"));
		direcc.setCp(rs.getInt("cp"));
		direcc.setProvincia(rs.getString("provincia"));
		
		return direcc;
	}


}
