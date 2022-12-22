package com.covinoc.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.covinoc.microservices.models.Usuario;
import com.covinoc.microservices.repositories.IUsuarioRepository;

import reactor.core.publisher.Mono;

@Service
public class UsuarioService { 
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public Usuario saveUsuario(Usuario usuario) {
		return iUsuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuario(){
		return iUsuarioRepository.findAll();
	}
	
	public void deleteCourse(Long id) {
		iUsuarioRepository.deleteById(id);
	}

    public Mono<ResponseEntity> crear(Usuario x) {
        return Mono.fromDirect(s -> {
        	
        	
            Optional<Usuario> optionalUser = this.iUsuarioRepository.consultarIdentificacion(x.getIdentificacion());

            if (optionalUser.isPresent()) {
                s.onNext(ResponseEntity.status(400).body("El usuario con identificaciÃ³n "+x.getIdentificacion()+" ya tiene existe"));
                s.onComplete();
            }
        	
            else {        Usuario usuario = this.iUsuarioRepository.save(x);
                    if (usuario.getId() != null) {
                        s.onNext(ResponseEntity.status(200).body(usuario));
                        s.onComplete();
                    } else {
                        s.onNext(ResponseEntity.status(400).body(ResponseEntity.status(400).body("No se Guardo")));
                        s.onComplete();
                    }
        }
            
        });
    }

}
