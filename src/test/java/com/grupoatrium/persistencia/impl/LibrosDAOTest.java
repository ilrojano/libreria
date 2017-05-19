/**
 * 
 */
package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

/**
 * @author ilr00819
 *
 */
public class LibrosDAOTest {
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private RowMapper<Libro> rowmapperLibro;
	

	/**
	 * clase de obtencion de todos los libros
	 * @return Listado de Libros
	 */
	public List<Libro> allLibros(){
		final String SQL_ALL_LIBROS="select * from Libro";
		return (List<Libro>)namedJdbcTemplate.query(SQL_ALL_LIBROS, rowmapperLibro);
	}
	
	/**
	 * metodo para recuperar un libro por su isbn
	 * @param isbn
	 * @return
	 */
	public Libro findLibros( String isbn){
		//query a ejecutar
		final String SQL_find_LIBROS="select * from Libro where isbn=:isbn";
		  
		//mapa de parametros
		Map<String,Object> parametros = new HashMap<String, Object>();
		   parametros.put("isbn", isbn);
		  return namedJdbcTemplate.queryForObject(SQL_find_LIBROS, parametros, rowmapperLibro); 
	}
	
	/**
	 * Método transacional crear Libro
	 * @param l
	 */
	@Transactional
	public void create(Libro l){
	final String SQL_INSERT="INSERT INTO libro (isbn,titulo,autores,Editorial,publicacion,precio,descripcion)"
												+ " VALUES (:isbn,:titulo,:autores,:edi,:publi,:precio,:desc)";  
	  final Libro libro= l;
      Map<String,Object>parametros= new HashMap <String, Object>();
      parametros.put("isbn",libro.getIsbn());
      parametros.put("titulo", libro.getTitulo());
      
      //recuperamos solo los nombres para que no de error de varchar
      String Autores="";
      for (Autor aut : libro.getAutores()) {  
		Autores+=aut.getNombre()+",";	
	}
     
      parametros.put("autores", Autores);
      
      
      parametros.put("edi", libro.getEditorial().getNif());
      parametros.put("publi",libro.getPublicacion());
      parametros.put("precio", libro.getPrecio());
      parametros.put("desc", libro.getDescripcion());
      int n = namedJdbcTemplate.update(SQL_INSERT, parametros);
      System.out.println("registros insertados: "+n);
     
}
	
	@Transactional
	public void delete(String isbn){
		final String SQL_DELETE="DELETE libro WHERE ISBN=:isbn";  
		   Map<String,Object>parametros= new HashMap <String, Object>();
		   parametros.put("isbn", isbn);
		   int n= namedJdbcTemplate.update(SQL_DELETE, parametros);
		   System.out.println("registros Eliminados: "+n);
	}

	/**
	 * @return the namedJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	/**
	 * @param namedJdbcTemplate the namedJdbcTemplate to set
	 */
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	/**
	 * @return the rowmapperLibro
	 */
	public RowMapper<Libro> getRowmapperLibro() {
		return rowmapperLibro;
	}

	/**
	 * @param rowmapperLibro the rowmapperLibro to set
	 */
	public void setRowmapperLibro(RowMapper<Libro> rowmapperLibro) {
		this.rowmapperLibro = rowmapperLibro;
	}

	
	
}
