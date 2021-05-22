/**
 * 
 */
package com.codesa.app.adminusuarios.enums;

/**
 * @author Gustavo Ramirez Aristizabal
 *
 */
public enum EnumResponseCode {

	USUARIO_CREADO_EXITOSAMENTE(1),
	ERROR_CREAR_USUARIO(2),
	USUARIO_EXISTENTE(3),
	USUARIO_ACTUALIZADO_EXITOSAMENTE(4),
	ERROR_ACTUALIZAR_USUARIO(5),
	USUARIO_ELIMINADO_EXITOSAMENTE(6),
	ERROR_ELIMINAR_USUARIO(7),
	USUARIO_INEXISTENTE(8);
	
	private final int valor;

    private EnumResponseCode(int valor) {
        this.valor = valor;
    }
    
    public int getValor()
    {
    	return this.valor;
    }
}
