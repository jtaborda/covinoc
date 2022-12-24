package com.covinoc.microservices.services;

import java.util.Calendar;
import java.util.Date;
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
	 	
    	Calendar calendar = Calendar.getInstance(); 
    	usuario.setFechaCreacionRegistro(calendar.getTime());    	
		return iUsuarioRepository.save(usuario);
	}
	
	 public Mono<ResponseEntity> getAllUsuario() {
		  return Mono.just(ResponseEntity.status(200).body(this.iUsuarioRepository.findAll()));
	}
	 
	 
	 public Optional<Usuario> getUsuarioById(Long id) {			
		  return iUsuarioRepository.findById(id);
	}

		public Mono<ResponseEntity> getUsuarioBycedula(Integer id) 
	 {			
		  return Mono.just(ResponseEntity.status(200).body( this.iUsuarioRepository.consultarIdentificacion(id) ) );
	 }
            
		 
	
	
	public void deleteUsuario(Long id) {
		iUsuarioRepository.deleteById(id);
	}
	Date date = new Date();
    public Mono<ResponseEntity> crear(Usuario x) {
    	
        return Mono.fromDirect(s -> {
        	
        	
            Optional<Usuario> optionalUser = this.iUsuarioRepository.consultarIdentificacion(x.getIdentificacion());

            if (optionalUser.isPresent()) {
                s.onNext(ResponseEntity.status(400).body("El usuario con identificacion "+x.getIdentificacion()+" ya tiene existe"));
                s.onComplete();
            }
        	
            else {        
            	
            	Calendar calendar = Calendar.getInstance(); 
            	x.setFechaCreacionRegistro(calendar.getTime());
            	Usuario usuario = this.iUsuarioRepository.save(x);
                    if (usuario.getId() != null) {
                        s.onNext(ResponseEntity.status(200).body(usuario));
                        s.onComplete();
                    } else {
                        s.onNext(ResponseEntity.status(500).body(ResponseEntity.status(500).body("No se Guardo")));
                        s.onComplete();
                    }
        }
            
        });
    }

}
