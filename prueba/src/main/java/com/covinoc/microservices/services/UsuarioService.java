package com.covinoc.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covinoc.microservices.models.Usuario;
import com.covinoc.microservices.repositories.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public Usuario saveCourse(Usuario course) {
		return iUsuarioRepository.save(course);
	}
	
	public List<Usuario> getAllCourses(){
		return iUsuarioRepository.findAll();
	}
	
	public void deleteCourse(Long id) {
		iUsuarioRepository.deleteById(id);
	}

}
