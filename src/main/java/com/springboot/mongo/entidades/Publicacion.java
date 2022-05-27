package com.springboot.mongo.entidades;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Publicacion")
public class Publicacion {
	
	@Id
	private BigInteger id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	
	private String titulo;
	private String descripcion;

	public Publicacion(BigInteger id, String titulo, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}

	

}
