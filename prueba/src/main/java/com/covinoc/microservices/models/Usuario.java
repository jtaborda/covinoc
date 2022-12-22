package com.covinoc.microservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "Usuario")
@Table(name = "\"Usuarios\"", schema = "public")
public class Usuario {
			
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;	
		
		@Column(name = "nombre", nullable = false)
		private String nombre;
		
		@Column(name = "telefono", nullable = false)
		private int telefono;

		@Column(name = "identificacion", nullable = false)
		private int identificacion;
		
		//sexo: F, M, ...
		@Column(name = "genero", nullable = false, length = 1)
		private String genero;
		
		@Column(name = "correo", nullable = false)
		private String correo;

		public int getIdentificacion() {
			return identificacion;
		}

		public void setIdentificacion(int identificacion) {
			this.identificacion = identificacion;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}


}
