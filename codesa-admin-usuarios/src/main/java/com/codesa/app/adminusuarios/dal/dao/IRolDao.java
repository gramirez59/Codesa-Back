/**
 * 
 */
package com.codesa.app.adminusuarios.dal.dao;

import org.springframework.data.repository.CrudRepository;

import com.codesa.app.adminusuarios.dal.entity.Rol;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
public interface IRolDao extends CrudRepository<Rol, Long> {

}
