/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.grupoatrium.modelo.Editorial;

/**
 * @author ilr00819
 *
 */
public class EditorialesDAOTest {
	private NamedParameterJdbcTemplate plantillaNamedEditorial;
	private RowMapper<Editorial> mapeadorEditorial;

	/**
	 * 
	 * @return List<Editorial>
	 */
	public List<Editorial> findAllEditorial() {
		final String SQL_ALL_EDITORIAL = "SELECT * FROM EDITORIAL";
		return (List<Editorial>) plantillaNamedEditorial.query(
				SQL_ALL_EDITORIAL, mapeadorEditorial);
	}

	public Editorial findEditorial(String NIF) {
		final String SQL_FIND_EDITORIAL = "SELECT * FROM EDITORIAL WHERE NIF=:N";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("N", NIF);
		System.out.println();		
		return (Editorial)plantillaNamedEditorial.queryForObject(SQL_FIND_EDITORIAL,
				parametros, mapeadorEditorial);

	}

	/**
	 * @return the plantillaNamedEditorial
	 */
	public NamedParameterJdbcTemplate getPlantillaNamedEditorial() {
		return plantillaNamedEditorial;
	}

	/**
	 * @param plantillaNamedEditorial
	 *            the plantillaNamedEditorial to set
	 */
	public void setPlantillaNamedEditorial(
			NamedParameterJdbcTemplate plantillaNamedEditorial) {
		this.plantillaNamedEditorial = plantillaNamedEditorial;
	}

	/**
	 * @return the mapeadorEditorial
	 */
	public RowMapper<Editorial> getMapeadorEditorial() {
		return mapeadorEditorial;
	}

	/**
	 * @param mapeadorEditorial
	 *            the mapeadorEditorial to set
	 */
	public void setMapeadorEditorial(RowMapper<Editorial> mapeadorEditorial) {
		this.mapeadorEditorial = mapeadorEditorial;
	}

}
