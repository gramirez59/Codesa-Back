/**
 * 
 */
package com.codesa.app.adminusuarios.bl.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codesa.app.adminusuarios.dal.dao.IRolDao;
import com.codesa.app.adminusuarios.dal.dao.IUserDao;
import com.codesa.app.adminusuarios.dal.dto.UserDto;
import com.codesa.app.adminusuarios.dal.entity.Rol;
import com.codesa.app.adminusuarios.dal.entity.Usuario;
import com.codesa.app.adminusuarios.enums.EnumResponseCode;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRolDao rolDao;

	@Override
	public List<UserDto> GetUsers(String nombre) {
		List<UserDto>usersDto = null;
		List<Usuario> users = null;
		if(nombre == null || nombre.isEmpty() || nombre.isBlank())
			users = (List<Usuario>) userDao.findAll();
		else
			users = (List<Usuario>) userDao.findAllByNombre(nombre);
		Comparator<UserDto> orderById = Comparator
                .comparing(UserDto::getId);
		usersDto = users.stream().map(user -> {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setNombre(user.getNombre());
			userDto.setActivo(user.getActivo());
			userDto.setRol(user.getRol().getId());
			return userDto;
		}).sorted(orderById) .collect(Collectors.toList());
		return usersDto;
	}

	@Override
	public Integer CreateUser(UserDto userDto) {
		Usuario newUser = new Usuario();
		Rol rol = rolDao.findById(userDto.getRol()).orElse(null);
		newUser.setNombre(userDto.getNombre().toUpperCase());
		newUser.setActivo(userDto.getActivo());
		newUser.setRol(rol);
		userDao.save(newUser);
		if(newUser.getId() != null)
			return EnumResponseCode.USUARIO_CREADO_EXITOSAMENTE.getValor();
		else
			return EnumResponseCode.ERROR_CREAR_USUARIO.getValor();
	}

	@Override
	public Integer UpdateUser(UserDto userDto) {
		Usuario user = userDao.findById(userDto.getId()).orElse(null);
		Rol rol = rolDao.findById(userDto.getRol()).orElse(null);
		if(user != null && rol != null) {
			user.setNombre(userDto.getNombre().toUpperCase());
			user.setActivo(userDto.getActivo());
			user.setRol(rol);
			userDao.save(user);
			return EnumResponseCode.USUARIO_ACTUALIZADO_EXITOSAMENTE.getValor();
		}
		else
			return EnumResponseCode.ERROR_ACTUALIZAR_USUARIO.getValor();
	}

	@Override
	public Boolean FindByName(String nombre) {
		List<Usuario> users = (List<Usuario>) userDao.findAllByNombre(nombre.toUpperCase());
		if(users.size() > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public Boolean FindById(Long id) {
		Usuario user = userDao.findById(id).orElse(null);
		if(user != null)
			return true;
		else
			return false;
	}

	@Override
	public Integer DeleteUser(Long id) {
		Usuario user = userDao.findById(id).orElse(null);
		if(user != null) {
			userDao.delete(user);
			return EnumResponseCode.USUARIO_ELIMINADO_EXITOSAMENTE.getValor();
		}
		else
			return EnumResponseCode.ERROR_ELIMINAR_USUARIO.getValor();
	}
}