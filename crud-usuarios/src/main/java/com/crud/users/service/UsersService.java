package com.crud.users.service;

import java.util.List;

import com.crud.users.dto.UsersDTO;

public interface UsersService {
	
	public UsersDTO crearUsuario(UsersDTO usersDTO);
	public List<UsersDTO> obtenerUsuarios();
	public UsersDTO obtenerUsuarioId(long id);
	public UsersDTO actualizarUsuario(UsersDTO usersDTO, long id);
	public void eliminarUsuario(long id);

}
