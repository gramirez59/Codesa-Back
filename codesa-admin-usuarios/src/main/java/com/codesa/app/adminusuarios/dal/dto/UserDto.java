/**
 * 
 */
package com.codesa.app.adminusuarios.dal.dto;

import org.springframework.lang.Nullable;

/**
 * @author Gustavo Ramírez Aristizabal
 *
 */
public class UserDto {

	@Nullable private Long id;
	private String nombre;
	private Boolean activo;
	private Long rol;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
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
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}
	
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	/**
	 * @return the rol
	 */
	public Long getRol() {
		return rol;
	}
	
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Long rol) {
		this.rol = rol;
	}	
}