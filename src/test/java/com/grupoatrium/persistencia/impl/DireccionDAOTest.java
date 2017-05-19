/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.grupoatrium.modelo.Direccion;


/**
 * @author ilr00819
 *
 */
public class DireccionDAOTest {
 private NamedParameterJdbcTemplate plantillaNamedDireccion;
 private RowMapper<Direccion> rowmapperDireccion;
	
	
	  public Direccion findDireccion(String calle) {
		  final String SQL_FIND_CALLE="select * from direccion where calle=:calle";
		  
			//mapa de parametros
			Map<String,Object> parametros = new HashMap<String, Object>();
			   parametros.put("calle", calle);
		  
		return plantillaNamedDireccion.queryForObject(SQL_FIND_CALLE, parametros, rowmapperDireccion); 
	}
	  /**
	   * devuelve todas las direcciones dadas de alta
	   * @return List<Direccion>
	   */
	  public List<Direccion> findAllDirecciones(){
		final String SQL_ALL_DIRECC="select * from direccion ";
		
		  return (List<Direccion>) plantillaNamedDireccion.query(SQL_ALL_DIRECC, rowmapperDireccion);
		  
	  }
	/**
	 * @return the plantillaNamedDireccion
	 */
	public NamedParameterJdbcTemplate getPlantillaNamedDireccion() {
		return plantillaNamedDireccion;
	}
	/**
	 * @param plantillaNamedDireccion the plantillaNamedDireccion to set
	 */
	public void setPlantillaNamedDireccion(
			NamedParameterJdbcTemplate plantillaNamedDireccion) {
		this.plantillaNamedDireccion = plantillaNamedDireccion;
	}
	/**
	 * @return the rowmapperDireccion
	 */
	public RowMapper<Direccion> getRowmapperDireccion() {
		return rowmapperDireccion;
	}
	/**
	 * @param rowmapperDireccion the rowmapperDireccion to set
	 */
	public void setRowmapperDireccion(MapeadorDireccion rowmapperDireccion) {
		this.rowmapperDireccion = rowmapperDireccion;
	}


}
