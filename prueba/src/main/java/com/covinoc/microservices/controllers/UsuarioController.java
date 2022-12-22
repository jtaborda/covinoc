package com.covinoc.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covinoc.microservices.models.Usuario;
import com.covinoc.microservices.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService courseService;
	
	@PostMapping("/usuario")
	public Usuario createCourse(@Validated @RequestBody Usuario course) {
		return courseService.saveCourse(course);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> readCourses(){
		return courseService.getAllCourses();
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateCourse(@PathVariable String id, @Validated @RequestBody Usuario usuario) {
		return courseService.saveCourse(usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}

}
