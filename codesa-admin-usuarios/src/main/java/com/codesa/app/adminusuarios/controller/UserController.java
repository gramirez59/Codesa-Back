/**
 * 
 */
package com.codesa.app.adminusuarios.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.codesa.app.adminusuarios.bl.service.IUserService;
import com.codesa.app.adminusuarios.dal.dto.UserDto;
import com.codesa.app.adminusuarios.enums.EnumResponseCode;
import com.codesa.app.adminusuarios.exception.MicroServiceException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	/**
	 * Instancia de Log para registrar eventos en la consola.
	 */
	private Logger Log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;

	/**
	 * Retorna todos los usuarios o los que coincidan con el criterio de busqueda.
	 * @param nombre
	 * @return
	 */
	@RequestMapping(value =  {"/GetUsers","/GetUsers/{nombre}"}, method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>>GetUsers(@PathVariable(required = false) String nombre) throws MicroServiceException {
		ResponseEntity<List<UserDto>> responseEntity = null;
		List<UserDto> usersList = null;
		try {
			usersList = userService.GetUsers(nombre);
			responseEntity = new ResponseEntity<List<UserDto>>(usersList, HttpStatus.OK);
		}
		catch (Exception e) {
			Log.error("UserController:GetUsers" + e.getStackTrace());
			responseEntity = new ResponseEntity<List<UserDto>>(new ArrayList<UserDto>(), HttpStatus.INTERNAL_SERVER_ERROR);
			throw new MicroServiceException(e);
		}
		return responseEntity;
	}
	
	/**
	 * Registra un usuario en la Base de Datos
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
	public ResponseEntity<Integer>CreateUser(@RequestBody UserDto userDto) throws MicroServiceException {
		ResponseEntity<Integer> responseEntity = null;
		Integer response = null;
		try {
			if(userService.FindByName(userDto.getNombre()))
				responseEntity = new ResponseEntity<Integer>(EnumResponseCode.USUARIO_EXISTENTE.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
			else {
				response = userService.CreateUser(userDto);
				if(response.intValue() == EnumResponseCode.USUARIO_CREADO_EXITOSAMENTE.getValor())
					responseEntity = new ResponseEntity<Integer>(EnumResponseCode.USUARIO_CREADO_EXITOSAMENTE.getValor(), HttpStatus.OK);
				else
					responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_CREAR_USUARIO.getValor(), HttpStatus.OK);
			}			
		}
		catch (Exception e) {
			Log.error("UserController:CreateUser" + e.getStackTrace());
			responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_CREAR_USUARIO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
			throw new MicroServiceException(e);
		}
		return responseEntity;
	}
	
	/**
	 * Actualiza un usuario en la Base de Datos
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.PUT)
	public ResponseEntity<Integer>UpdateUser(@RequestBody UserDto userDto) throws MicroServiceException {
		ResponseEntity<Integer> responseEntity = null;
		Integer response = null;
		try {
			response = userService.UpdateUser(userDto);
			if(response.intValue() == EnumResponseCode.USUARIO_ACTUALIZADO_EXITOSAMENTE.getValor())
				responseEntity = new ResponseEntity<Integer>(EnumResponseCode.USUARIO_ACTUALIZADO_EXITOSAMENTE.getValor(), HttpStatus.OK);
			else
				responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_ACTUALIZAR_USUARIO.getValor(), HttpStatus.OK);
		}
		catch (Exception e) {
			Log.error("UserController:UpdateUser" + e.getStackTrace());
			responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_ACTUALIZAR_USUARIO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
			throw new MicroServiceException(e);
		}
		return responseEntity;
	}
	
	/**
	 * Elimina un usuario en la base de datos.
	 * @param id
	 * @return
	 * @throws MicroServiceException
	 */
	@RequestMapping(value = "/DeleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer>DeleteUser(@PathVariable Long id) throws MicroServiceException {
		ResponseEntity<Integer> responseEntity = null;
		Integer response = null;
		try {
			if(!userService.FindById(id)) 
				responseEntity = new ResponseEntity<Integer>(EnumResponseCode.USUARIO_INEXISTENTE.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
			else {
				response = userService.DeleteUser(id);
				if(response.intValue() == EnumResponseCode.USUARIO_ELIMINADO_EXITOSAMENTE.getValor())
					responseEntity = new ResponseEntity<Integer>(EnumResponseCode.USUARIO_ELIMINADO_EXITOSAMENTE.getValor(), HttpStatus.OK);
				else
					responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_ELIMINAR_USUARIO.getValor(), HttpStatus.OK);
			}
		}
		catch (Exception e) {
			Log.error("UserController:DeleteUser" + e.getStackTrace());
			responseEntity = new ResponseEntity<Integer>(EnumResponseCode.ERROR_ELIMINAR_USUARIO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
			throw new MicroServiceException(e);
		}
		return responseEntity;
	}
}
