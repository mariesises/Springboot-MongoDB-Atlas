package com.springboot.mongo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.mongo.controller.register.UsuarioRegistroDTO;
import com.springboot.mongo.entidades.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	public Usuario addUsuario(UsuarioRegistroDTO registroDTO);
	


}
