package com.springboot.mongo.controller.register;

import java.math.BigInteger;

public class PublicacionDTO {
	
	
	private BigInteger id;
	private String titulo;
	private String descripcion;
	
	public PublicacionDTO(BigInteger id_publicacion, String titulo, String descripcion) {
		super();
		this.id = id_publicacion;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public BigInteger getId_publiacion() {
		return id;
	}

	public void setId_publiacion(BigInteger id_publicacion) {
		this.id = id_publicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PublicacionDTO() {
		
	}

}
