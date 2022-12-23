package com.covinoc.microservices.controllers;

import java.util.List;
import java.util.Optional;

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
	
	
//Crear Usuario
	 @PostMapping(consumes = "application/json", produces = "application/json")
	    public  Mono<ResponseEntity> crear(@Valid @RequestBody Usuario usuario) {
	        return this.usuarioService.crear(usuario);
	    }
	
	 //Editar  Usuario
	@PutMapping("/update/")
	public Usuario updateUsuario(@Validated @RequestBody Usuario usuario,
		 BindingResult result) {
				if (result.hasErrors()) {
				  throw new InvalidDataException(result);
				}
		return usuarioService.saveUsuario(usuario);
	
	}	
		
	
	 //Borrar  Usuario
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/delete/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCourse(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
	}

	
	//Listar Todos
	@Override
    @GetMapping(value = "/listarAll")
	public Mono<ResponseEntity> listar() {
		return usuarioService.getAllUsuario();
	}


	//Listar por Id
	@Override
    @GetMapping(value = "/listarById")
	public  Optional<Usuario> porId(Long id) {
		return usuarioService.getUsuarioById(id);
	}
	
}
