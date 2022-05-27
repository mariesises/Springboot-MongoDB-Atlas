package com.springboot.mongo.controller.register;

public class UsuarioLogin {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UsuarioLogin [email=" + email + ", password=" + password + "]";
	}

	public UsuarioLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
