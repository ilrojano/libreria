package com.grupoatrium.cliente;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.AutorDAOTest;
import com.grupoatrium.persistencia.impl.EditorialesDAOTest;
import com.grupoatrium.persistencia.impl.LibrosDAOTest;

public class principalTestTest {

	@Test
	public void testMain() {
		// Levantar el contexto de Spring
		// Crear el contenedor de beans a partir del archivo applicationContext.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");
		System.out.println("################# BIENVENIDO A LA LIBRERIA ##############################");
						
		LibrosDAOTest libroTest = context.getBean("librosDaoTest",LibrosDAOTest.class);
		 for (Libro l : libroTest.allLibros()) {
			System.out.println(l.getIsbn());
		}
		 
		 System.out.println("TODOS LOS AUTORES "+context.getBean("autorDaoTest",AutorDAOTest.class).findAllAutor());
		 
		 System.out.println("crear nuevo Libro");
		 Libro libro= new Libro();
		 libro.setIsbn("ivan23213123");
		 libro.setAutores(context.getBean("autorDaoTest",AutorDAOTest.class).findAllAutor());
		 libro.setDescripcion("libro creado de prueba");
		 libro.setEditorial(context.getBean("editorialesDaoTest",EditorialesDAOTest.class).findEditorial("12345345F"));
		 libro.setPrecio(45.68);
		 libro.setPublicacion(12321313);
		 libro.setTitulo("Prueba libro");
		 libroTest.create(libro);
		 
		 System.out.println("libro creado "+libroTest.findLibros("ivan23213123"));
		 
			
		 System.out.println("creacion de Autor por tx programatica");
		 AutorDAOTest autorDao = context.getBean("autorDaoTest",AutorDAOTest.class);
		 autorDao.createAutor(new Autor("Mario", "ESPAÑOLA", "my sun"));
		 System.out.println("Listar todos los autores:"+autorDao.findAllAutor());
		 
		 assertEquals("RESULTADO ESPERADO", autorDao.findAllAutor().toString(), "[Autor [nombre=IVAN, nacionalidad=ESPAÑOLA, comentarios=PRIMER AUTOR], Autor [nombre=LEIRE, nacionalidad=ESPAÑOLA, comentarios=SEGUNDO AUTOR], Autor [nombre=Mario, nacionalidad=ESPAÑOLA, comentarios=my sun]]");
	}

}
