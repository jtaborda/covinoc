package com.covinoc.microservices.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.covinoc.microservices.models.Usuario;

import reactor.core.publisher.Mono;

public interface Controlador<T> {
	

	    public Mono<ResponseEntity> crear(T datos);
		Mono<ResponseEntity> listar();
		Optional<Usuario> porId(Long id);
		public void deleteCourse(Long id);
}
