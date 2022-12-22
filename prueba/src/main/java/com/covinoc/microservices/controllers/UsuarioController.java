package com.covinoc.microservices.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.covinoc.microservices.models.Usuario;
import com.covinoc.microservices.services.UsuarioService;
import com.covinoc.microservices.utils.InvalidDataException;
import javax.validation.Valid;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
public class UsuarioController implements Controlador<Usuario>{
	
	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping("/usuarios")
	public List<Usuario> buscarUsuarios(){
		return usuarioService.getAllUsuario();
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateCourse(@PathVariable Integer id, @Validated @RequestBody Usuario usuario,
		 BindingResult result) {
				if (result.hasErrors()) {
				  throw new InvalidDataException(result);
				}
		return usuarioService.saveUsuario(usuario);
	
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCourse(@PathVariable Long id) {
		usuarioService.deleteCourse(id);
	}

	@Override
	public Mono<ResponseEntity> consultar(String datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ResponseEntity> listar(String datos) {
		// TODO Auto-generated method stub
		return null;
	}

	 @PostMapping(consumes = "application/json", produces = "application/json")
	    public ResponseEntity crearSync(@Valid @RequestBody Usuario usuario) {
	        return this.usuarioService.crear(usuario).block();
	    }

	@Override
	public Mono<ResponseEntity> actualizar(Usuario datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ResponseEntity> eliminar(String datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ResponseEntity> crear(Usuario datos) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

}
