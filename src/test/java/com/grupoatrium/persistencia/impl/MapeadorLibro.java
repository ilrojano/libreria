/**
 * @author ilr00819
 */
package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

/**
 * @author ilr00819
 
 */
public class MapeadorLibro implements RowMapper<Libro>{
	
	//bean editorialDao
	private EditorialesDAOTest editorial;
	//bean autorDao
	private AutorDAOTest autorDao;


	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro= new Libro();
		libro.setIsbn(rs.getString("isbn"));
		libro.setTitulo(rs.getString("titulo"));
		
		System.out.println("buscando editorial:"+rs.getString("editorial"));
		try{
				libro.setEditorial(editorial.findEditorial(rs.getString("editorial")));
				System.out.println(libro.getEditorial());
		}catch(Exception e){
			System.err.println("No ha devuelto resultados "+ e);
		}
		
		
		//recuperamos la lista de Autores que hemos creado al hacer el insert separados por comas
		String[] lista= rs.getString("autores").split(",");
		List<Autor>autores = new ArrayList<Autor>();
		libro.setAutores(autores);
		
		for (String string : lista) {
			System.out.println("buscando autor"+string);
			Autor e= autorDao.findAutor(string);
		autores.add(e);
	}
		
		System.out.println("libro devuelto por mapeadorLibro:"+libro);
		return libro;
	}

	/**
	 * @return the editorial
	 */
	public EditorialesDAOTest getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(EditorialesDAOTest editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the autorDao
	 */
	public AutorDAOTest getAutorDao() {
		return autorDao;
	}

	/**
	 * @param autorDao the autorDao to set
	 */
	public void setAutorDao(AutorDAOTest autorDao) {
		this.autorDao = autorDao;
	}
	
	

}
