/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.grupoatrium.modelo.Autor;

/**
 * @author ilr00819
 *
 */
public class AutorDAOTest {

	NamedParameterJdbcTemplate plantillaAutor;
	RowMapper<Autor> rowmapperAutor;
	TransactionTemplate transactionTemplate;
	/**
	 * devuelve el autor que coincide con el nombre
	 * @param nombre
	 * @return
	 */
	public Autor findAutor(String nombre){
		final String SQL_FIND_AUTOR="select * from autor where nombre=:aut";
		Map<String,String> propiedades= new HashMap<String,String>();
		propiedades.put("aut", nombre);
		return plantillaAutor.queryForObject(SQL_FIND_AUTOR, propiedades, rowmapperAutor);
	}
	/**
	 * encontrar todos los autores
	 * @return
	 */
	public List<Autor> findAllAutor(){
		final String SQL_ALL_AUTORES="SELECT * FROM AUTOR ";
		return (List<Autor>) plantillaAutor.query(SQL_ALL_AUTORES,  rowmapperAutor);	
	}
	
	/**
	 * Creacion de autor a traves de una transaccion programatica
	 * @param autor
	 */
	public void createAutor(final Autor autor){
		transactionTemplate.execute(new TransactionCallback<Autor>(
				) {

					
public Autor doInTransaction(TransactionStatus status) {
String SQL_INSERT="INSERT INTO AUTOR VALUES(:aut,:naci,:comment)";
Map<String,Object> paramMap= new HashMap<String, Object>();
paramMap.put("aut", autor.getNombre());
paramMap.put("naci",autor.getNacionalidad());
paramMap.put("comment", autor.getComentarios());
plantillaAutor.update(SQL_INSERT, paramMap);
						
						return autor;
					}
		});
	}
	

	/**
	 * @return the plantillaAutor
	 */
	public NamedParameterJdbcTemplate getPlantillaAutor() {
		return plantillaAutor;
	}

	/**
	 * @param plantillaAutor the plantillaAutor to set
	 */
	public void setPlantillaAutor(NamedParameterJdbcTemplate plantillaAutor) {
		this.plantillaAutor = plantillaAutor;
	}

	/**
	 * @return the rowmapperAutor
	 */
	public RowMapper<Autor> getRowmapperAutor() {
		return rowmapperAutor;
	}

	/**
	 * @param rowmapperAutor the rowmapperAutor to set
	 */
	public void setRowmapperAutor(RowMapper<Autor> rowmapperAutor) {
		this.rowmapperAutor = rowmapperAutor;
	}
	
	/**
	 * @return the transactionTemplate
	 */
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	
	/**
	 * @param transactionTemplate the transactionTemplate to set
	 */
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	

}

