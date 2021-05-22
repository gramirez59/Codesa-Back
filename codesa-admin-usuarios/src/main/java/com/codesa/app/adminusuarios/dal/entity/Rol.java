/**
 * 
 */
package com.codesa.app.adminusuarios.dal.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
@Entity
@Table(name = "Rol")
public class Rol implements Serializable {
	
	/**
	 * Identificador del Rol
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	
	/**
	 * Nombre del Rol
	 */
	@Column(name = "nombre")
	private String nombre;	
	

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
	 * Identificador unico de clase
	 */
	private static final long serialVersionUID = 4494066217478273920L;
}