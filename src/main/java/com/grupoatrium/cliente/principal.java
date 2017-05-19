/**
 * 
 */
package com.grupoatrium.cliente;

import java.util.List;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;

/**
 * @author ilr00819
 *
 */
public class principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Levantar el contexto de Spring
				// Crear el contenedor de beans a partir del archivo applicationContext.xml
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				System.out.println("################# BIENVENIDO A LA LIBRERIA ##############################");
				
				System.out.println("\n............trama DAO .................................................");
				System.out.println("Datos del Bean connectionMgr cargados por properties:"+context.getBean("connectionMgr"));
				System.out.println("Datos del Bean connectionMgr2 cargados por properties:"+context.getBean("connectionMgr2"));
				System.out.println("Datos del Bean editorialesDAO cargados por properties:"+context.getBean("editorialesDAO"));
				System.out.println("Datos del Bean librosDAO cargados por properties:"+context.getBean("librosDAO"));
			
			
				
				System.out.println("\n............trama de libros.................................................");
				System.out.println("bean libro1 inicializado por constructor index:"+context.getBean("libro1"));
				System.out.println("bean libroC inicializado por constructor con nombre C::"+context.getBean("libroC"));
				
				System.out.println("\n............ trama de Autores .................................................");
				System.out.println("bean autor1  inicializado por inyeccion de propiedades"+context.getBean("autor1"));
				
				@SuppressWarnings("unchecked")
				List<Autor> listaAutores= (List<Autor>) context.getBean("listaAutores");
				int i=0;
				for (Autor autor : listaAutores) {
					System.out.println("util:List: listaAutores id:"+i++ +" "+autor.toString());
				}
				
				System.out.println("\n............ trama de Direcciones .............................................");
				System.out.println("bean direccion1  inicializado por inyeccion depropiedades name p "+context.getBean("direccion1"));
				
				System.out.println("\n............ trama de Editorial .............................................");
				System.out.println("bean direccion1  inicializado por inyeccion depropiedades name p "+context.getBean("editrorial1"));
			
				
			
	}

}
