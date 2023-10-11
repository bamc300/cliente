package com.crud.users.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.users.dto.UsersDTO;
import com.crud.users.entity.Users;
import com.crud.users.exceptions.ResourceNotFoundExeption;
import com.crud.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UsersDTO crearUsuario(UsersDTO usersDTO) {
		// TODO Auto-generated method stub
		Users users = mapearEntidad(usersDTO);
		Users nuevoUsuario=usersRepository.save(users);
		UsersDTO usuariosRespuesta=mapearDTO(nuevoUsuario);
		return usuariosRespuesta;
	}

	@Override
	public List<UsersDTO> obtenerUsuarios() {
		List<Users> usuarios=usersRepository.findAll();
		return usuarios.stream().map(user -> mapearDTO(user)).collect(Collectors.toList());
	}
	private UsersDTO mapearDTO(Users users) {
		UsersDTO usersDTO=new UsersDTO();
		usersDTO.setId(users.getId());
		usersDTO.setNombre(users.getNombre());
		usersDTO.setEmail(users.getEmail());
		usersDTO.setPassword(passwordEncoder.encode(users.getPassword()));
		
		return usersDTO;
		
	}
	private Users mapearEntidad(UsersDTO usersDTO) {
        Users users = new Users();
		users.setId(usersDTO.getId());
		users.setNombre(usersDTO.getNombre());
		users.setEmail(usersDTO.getEmail());
		users.setPassword(usersDTO.getPassword());
		return users;
	}

	@Override
	public UsersDTO obtenerUsuarioId(long id) {
		Users users = usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Usuarios", "id", id));
		return mapearDTO(users);
	}

	@Override
	public UsersDTO actualizarUsuario(UsersDTO usersDTO, long id) {
		Users users = usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Usuarios", "id", id));
		
		
		users.setNombre(usersDTO.getNombre());
		users.setEmail(usersDTO.getEmail());
		users.setPassword(usersDTO.getPassword());
		Users usuarioActualizado=usersRepository.save(users);
		return mapearDTO(usuarioActualizado);
	}

	@Override
	public void eliminarUsuario(long id) {
		Users users = usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Usuarios", "id", id));
		usersRepository.delete(users);
		
	}

}
