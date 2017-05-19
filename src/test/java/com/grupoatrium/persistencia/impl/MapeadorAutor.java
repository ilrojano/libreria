/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Autor;

/**
 * clase mapeadora del resultset de la tabla Autor
 * @author ilr00819
 *
 */
public class MapeadorAutor implements RowMapper<Autor> {

	
	public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Autor autor = new Autor( );
		autor.setNombre(rs.getString("nombre"));
		autor.setComentarios(rs.getString("comentarios"));
		autor.setNacionalidad(rs.getString("nacionalidad"));
		
		return autor;
	}
}
