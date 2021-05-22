/**
 * 
 */
package com.codesa.app.adminusuarios.dal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codesa.app.adminusuarios.dal.entity.Usuario;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
public interface IUserDao extends CrudRepository<Usuario, Long> {

	/**
	 * Retorna todos los usuarios que coincidan con un criterio de busqueda.
	 * @param nombre
	 * @return
	 */
	List<Usuario>findAllByNombre(String nombre);
}
