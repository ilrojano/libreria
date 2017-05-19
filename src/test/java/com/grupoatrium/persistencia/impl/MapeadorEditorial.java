/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Editorial;

/**
 * @author ilr00819
 *
 */
public class MapeadorEditorial implements RowMapper<Editorial> {
	//bean direccionDaoTest 
	DireccionDAOTest direccionDAOTest;
	
	public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Editorial editorial= new Editorial();
		editorial.setNif(rs.getString(1));
		editorial.setNombre(rs.getString(2));
		editorial.setDireccion(direccionDAOTest.findDireccion(rs.getString("direccion")));
		return editorial;
	}
	/**
	 * @return the direccionDAOTest
	 */
	public DireccionDAOTest getDireccionDAOTest() {
		return direccionDAOTest;
	}
	/**
	 * @param direccionDAOTest the direccionDAOTest to set
	 */
	public void setDireccionDAOTest(DireccionDAOTest direccionDAOTest) {
		this.direccionDAOTest = direccionDAOTest;
	}

}
