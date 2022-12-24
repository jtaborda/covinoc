package com.covinoc.microservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins ="http://localhost:4200")
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
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
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
    @GetMapping(value = "/listarById/{id}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public  Optional<Usuario> porId(@PathVariable Long id) {
		return usuarioService.getUsuarioById(id);
	}
	
	
	//buscar por cedula
		@Override
	    @GetMapping(value = "/listarByCedula/{cedula}")
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public Mono<ResponseEntity> porCedula(@PathVariable Integer cedula) {
			return usuarioService.getUsuarioBycedula(cedula);
		}
	
}
