/**
 * 
 */
package com.grupoatrium.modelo;

/**
 * @author ilr00819
 *
 */
public class Editorial {
	private String nif;
	private String nombre;
	private Direccion direccion;
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}
	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", direccion=" + direccion
				+ ", nif=" + nif + "]";
	}
		
}
