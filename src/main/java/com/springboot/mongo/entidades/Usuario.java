package com.springboot.mongo.entidades;

import java.util.Collection;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Usuario")
public class Usuario {

	@Id
	private String id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

	private String nombre;
	private String apellidos;
	private String email;
	private String alias;
	private String password;

	@DocumentReference
	private Collection<Rol> roles;

	public Usuario(String id, String nombre, String apellidos, String email, String alias, String password,
			Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.alias = alias;
		this.password = password;
	}

	public Usuario(String nombre, String apellidos, String email, String alias, String password,
			Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.alias = alias;
		this.password = password;
	}

	public Usuario() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alias, apellidos, password, email, id, nombre);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", alias="
				+ alias + ", password=" + password + "]";
	}

}
