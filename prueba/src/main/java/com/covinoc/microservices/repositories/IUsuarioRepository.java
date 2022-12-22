package com.covinoc.microservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covinoc.microservices.models.Usuario;



@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	 @Query("SELECT u FROM Usuario u where u.identificacion = ?1")
	    Optional<Usuario> consultarIdentificacion(int ideentificacion);
	 
}
