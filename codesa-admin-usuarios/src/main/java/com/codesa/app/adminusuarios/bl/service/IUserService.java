/**
 * 
 */
package com.codesa.app.adminusuarios.bl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codesa.app.adminusuarios.dal.dto.UserDto;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
@Service
public interface IUserService {

	/**
	 * Retorna todos los usuarios o los que coincidan con el criterio de busqueda.
	 * @param nombre
	 * @return
	 */
	List<UserDto>GetUsers(String nombre);
	
	/**
	 * Registra un usuario en la Base de Datos
	 * @param userDto
	 * @return
	 */
	Integer CreateUser(UserDto userDto);
	
	/**
	 * Actualiza un usuario en la Base de Datos
	 * @param userDto
	 * @return
	 */
	Integer UpdateUser(UserDto userDto);
	
	/**
	 * Consulta por nombre de usuario, devuelve true si existe un usuario con ese nombre o false si no encuentra resultados
	 * @param nombre
	 * @return
	 */
	Boolean FindByName(String nombre);
	
	/**
	 * Consulta por id de Usuario, devuelte true si existe un usuario con ese id o false si no encuentra resultados
	 * @param id
	 * @return
	 */
	Boolean FindById(Long id);
	
	/**
	 * Elimina un usuario en la base de datos.
	 * @param id
	 * @return
	 */
	Integer DeleteUser(Long id);
}
