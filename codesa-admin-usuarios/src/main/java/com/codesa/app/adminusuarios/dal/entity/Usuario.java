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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gustavo Ramírez Aristizabal
 *
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	/**
	 * Identificador del Usuario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	
	/**
	 * Nombre del Usuario
	 */
	@Column(name = "nombre")
	private String nombre;
	
	/**
	 * Estado del usuario en el sistema
	 */
	@Column(name = "activo")
	private Boolean activo;
	
	/**
	 * Rol que posee el usuario
	 */
	@JoinColumn(name = "idrol")
	@ManyToOne(optional = false)
	private Rol rol;	
	
	
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
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}



	/**
	 * Identificador unico de clase
	 */
	private static final long serialVersionUID = 2212276690435235942L;
}