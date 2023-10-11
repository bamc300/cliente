package com.crud.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.users.dto.UsersDTO;
import com.crud.users.service.UsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public ResponseEntity<UsersDTO> guardarUser(@RequestBody UsersDTO usersDTO){
		return new ResponseEntity<>(usersService.crearUsuario(usersDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<UsersDTO> listarUsers(){
		return usersService.obtenerUsuarios();
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> obtenerUsusarioId( @PathVariable(name = "id")long id){
		return ResponseEntity.ok(usersService.obtenerUsuarioId(id));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsersDTO> actualizarUsuario(@RequestBody UsersDTO usersDTO, @PathVariable(name = "id")long id){
				return new ResponseEntity<>(usersService.actualizarUsuario(usersDTO, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id")long id){
			usersService.eliminarUsuario(id);
			return new ResponseEntity<>("Usuario Eliminado",HttpStatus.OK);
	}
	
}
